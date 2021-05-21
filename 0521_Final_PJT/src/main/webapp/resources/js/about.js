$(document).ready(function() {
    $('#new-notice').click(function() {
        $('#notice-modal').modal();
    });

    $('#write-notice').click(function() {
        let title = $('#title').val();
        let paragraph = $('#paragraph').val();

        localStorage.setItem(title, paragraph);
        let div = `<div class="col-lg-4 mb-3">
                    <div class="card h-60 text-center">
                      <div class="card-body">
                        <h4 class="card-title notice">${title}</a></h4>
                      </div>
                    </div>
                  </div>`
        $('#notice-content').append(div);
        $('#title').val('');
        $('#paragraph').val('');
    });

    for(let i = 0; i < localStorage.length; i++) {
        let t = localStorage.key(i);
        if(t.includes('id@')) {
            continue;
        }
        let div = `<div class="col-lg-4 mb-3">
                    <div class="card h-60 text-center">
                      <div class="card-body">
                        <h4 class="card-title notice">${t}</a></h4>
                      </div>
                    </div>
                  </div>`
        $('#notice-content').append(div);
    }

    $(document).on("click", ".card-title.notice", function() {
        let title = $(this).text();
        let paragraph = localStorage.getItem(title);
        $('#notice-title').text(title);
        $('#notice-paragraph').text(paragraph);
    })
})