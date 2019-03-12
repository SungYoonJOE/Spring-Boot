/**
 * 
 */

$(document).ready(function () {
    $.ajax({
        url: "/freeboardCommentList",
        type: "get",
        dataType: "json",
        success: function (result) {
            alert(result);
        },
        error: function name() {
            alert("실패")
        }
    });
    function getFormData(data) {
        var unindexed_array = data;
        var indexed_array = {};
        $.map(unindexed_array, function(n, i) {
            indexed_array[n['name']] = n['value'];
        });
        return indexed_array;
    }
    $('#defaultCommentWrite').click(function () {
        var formData = $('#freeboardComment0').serializeArray();
        $.ajax({
            url : '/freeboardCommentWrite',
            dataType : 'json',
            type:'POST',
            contentType : 'application/json',
            data : JSON.stringify(getFormData(formData)),
            success : function () {
                console.log("inserted");
            },
            error : function () {
                console.log("not inserted");
            }
        });
    });
});