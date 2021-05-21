$(document).ready(function() {
	console.log(window);
    $('#edit-information').click(function() {
        $('#edit-information-modal').modal();
    });

//    $.ajax({
//        url: 'csv/address.csv',
//        dataType: 'text',
//    }).done(success);
//    let addressData;
//    function success(data) {
//        addressData = data.split('\n');
//    }

//    $('#select-gu').change(function() {
//        let gu = $('#select-gu').val();
//        if(gu === 'default') {
//            let optTag = `<option value="동">동</option>`;
//            $('#select-dong').append(optTag);
//        }
//        $('#select-dong').empty();
//        let item = [];
//        for(let i = 0; i < addressData.length; i++) {
//            if(addressData[i].includes(gu)) {
//                let address = addressData[i].substring(6+gu.length, addressData[i].length);
//                item.push(address);
//            }
//        }
//
//        for(let i = 0; i < item.length; i++) {
//            let optTag = `<option value="${item[i]}">${item[i]}</option>`;
//            $('#select-dong').append(optTag);
//        }
//    });

    $('#goService').click(function() {
    	var open = window.open('services.html', 'service', '_parent');
    });

    $('#btn-edit-information').click(function() {
        let id = 'id@' + $('#modal-id').val();
        let pw = $('#modal-pw').val();

        let load = JSON.parse(localStorage.getItem(id));
        const verification = load["password"];
        if (verification === pw) {   // 아이디와 비밀번호가 일치하면
            let newPassword = $('#modal-edit-pw').val();
            let newPasswordConfirm = $('#modal-edit-pw-confirm').val();

            if(newPassword === newPasswordConfirm) {
                let newEmail = $('#modal-edit-email').val();
                if(newEmail === null || newPassword === null) {
                    alert('* 표시는 필수 입력사항 입니다.')
                }
                let newPhone = $('#modal-edit-phone').val();
                let newMessage = $('#modal-edit-message').val();
                let list = {
                    'password' : newPassword,
                    'email' : newEmail,
                    'phone' : newPhone,
                    'message' : newMessage
                };
                localStorage.setItem(id, JSON.stringify(list));
                alert('성공적으로 변경되었습니다.');
            } else {
                alert('변경하려는 비밀번호가 일치하지 않습니다.');
            }
        } else {
            alert("아이디와 비밀번호를 다시 확인해주세요.");
        }
    });
})