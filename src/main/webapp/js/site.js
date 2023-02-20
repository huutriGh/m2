$(function () {
    $("#connect").click(function () {
        $.ajax({
            url: 'downloadAsync',
            type: 'GET',
            xhr: function () {
                const xhr = $.ajaxSettings.xhr();
                xhr.onprogress = function (e) {

                    if (e.lengthComputable) {
                        console.log(e.loaded + "/" + e.total);

                        console.log("Partition Data: ", e.currentTarget.responseText);


                    } else {

                        console.log(e.loaded);
                    }
                };

                return xhr;
            }
        }).done(function (e) {
            console.log(e);
            console.log("Done");
        }).fail(function (e) {
            console.log(e);
        });
    })
});