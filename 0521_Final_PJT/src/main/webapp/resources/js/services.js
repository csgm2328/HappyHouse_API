$(document).ready(function() {
	// 주소 받아오기
	var addr = opener.document.getElementById("select-city").value;
	addr += opener.document.getElementById("select-gu").value;
	var addrDong = opener.document.getElementById("select-dong").value;
	console.log(opener.document);
	console.log(addr);
	
	//data.go.kr 데이터 받아오기
	var xmldata;
	var totalLng = new Array();
	var totallat = new Array();
	var totalcost = new Array();
	var totalname = new Array();
	var markers = [];
	var totalidx = 0;
	
	$.ajax({ url: 'res/AptDealHistory.xml', // 읽어올 문서
		type: 'GET', // 방식
		dataType: 'xml', // 문서 타입
		timeout: 1000, // 시간 설정
		error: function(){ // 로딩 에러시 
			alert('Error loading XML document'); 
		}, 
		success: function(xml){
			init(addr + addrDong, $(this).find("거래금액").text());
			
			$(xml).find('item').each(function(){ // xml 문서 item 기준으로 분리후 반복
				
				if($(this).find("법정동").text() === addrDong){
					var apart = $(this).find("아파트").text();
					var cost = $(this).find("거래금액").text();
					var date = $(this).find("년").text() + "." +$(this).find("월").text() + "." +$(this).find("일").text();
					$("#apartinfo").append(`<div class = "apart">
						<hr>
						<div class = "apartname">아파트이름 : ${apart}</div>
						<div class = "cost">거래 금액: ${cost}</div>
						<div class = "date">날짜: ${date}</div>
					</div>`
					); // #id 에 view_text 삽입 
					
					init(addr + addrDong + $(this).find("지번").text(), cost, apart);
					console.log(addr + addrDong + $(this).find("지번").text());
				}
			}); 
			
		} 
	});
	
	
	//주소로 위도 경도 계산
	function init(str, cost, name) {
		var xhr = new XMLHttpRequest();
		var url = 'https://maps.googleapis.com/maps/api/geocode/json?address='+str+'&key=AIzaSyAAHuS3QzpixOgCb9AOfb9yE7ITxgVmigs';
		
		xhr.open('GET', url);
		xhr.onreadystatechange = function () {
		    if (this.readyState === 4) {
		    	let loadedJSON= JSON.parse(xhr.responseText);
		    	var lng = (loadedJSON.results[0].geometry.location.lng);
		    	var lat = (loadedJSON.results[0].geometry.location.lat);
		    	
		    	return (function() {
		    		totallat.push(Number(lat));
					totalLng.push(Number(lng));
					totalcost.push(cost);
					totalname.push(name);
					console.log("push"+lng);
					
					if(totalidx == 0){
						addMap();
						totalidx += 1;
					}
					else {
						markers.push(addMarker());
						console.log(markers);
					}
					
				})();
		    }
		};

		xhr.send('');
	}
	
	function addMarker() { //구글 맵 마커 찍기
		var marker;
		var len = totallat.length-1;
		marker = new google.maps.Marker({
			position: {lat: totallat[totallat.length-1], lng: totalLng[totalLng.length-1]},
			map: map,
		});
		google.maps.event.addListener(marker, 'click', function() {
			map.setCenter(this.getPosition());
			map.setZoom(17);
			
			$(".apart").each(function() {
				if($(this).find(".apartname").text() !== '아파트이름 : '+totalname[len]){
					$(this).remove();
				}
			});
			var infowindow = new google.maps.InfoWindow({
				content: totalcost[len]
			});
			infowindow.open(map, this);
		});
		return marker;
	}
	
	function addMap(){	//구글 맵
		map = new google.maps.Map(document.getElementById("map"), {
			center: {
				lat: Number(totallat[0]),
				lng: Number(totalLng[0])
			},
			zoom: 15
		});
	}
	
	
})