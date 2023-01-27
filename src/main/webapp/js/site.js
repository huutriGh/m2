$(function () {
    $("#connect").click(function () {
        $.ajax({
            url: 'downloadasync',
            type: 'GET',
            xhr: function () {
                var xhr = $.ajaxSettings.xhr();
                xhr.onprogress = function (e) {
                    if (e.lengthComputable) {
                        console.log(e.loaded / e.total);
                    } else {
                        console.log(e.loaded);
                    }
                };
                return xhr;
            }
        }).done(function (e) {
            console.log("Done");
        }).fail(function (e) {
            console.log(e);
        });
    })
});