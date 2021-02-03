window.onload=function (){
    init();
}
function init(){
    $(".sel-left>li").each(function (index,el){
        switch (index){
            case 0:
                $(el).css("border-right","1px solid #888888");
                $(el).click(function(){
                    $(this).addClass("on");
                    $(this).siblings().removeClass("on");
                });
                break;
            case 1:
                $(el).css("border-right","1px solid #888888");
                $(el).click(function(){
                    $(this).addClass("on")
                    $(this).siblings().removeClass("on");
                });
                break;
            case 2:
                $(el).css("border-right","1px solid #888888");
                $(el).click(function(){
                    $(this).addClass("on")
                    $(this).siblings().removeClass("on");

                });
                break;
            case 3:
                $(el).click(function(){
                    $(this).addClass("on")
                    $(this).siblings().removeClass("on");

                });
                break;
        }
    })
    $(".order-infomation>div").each(function (index,el){
        switch (index){
            case 0:
                $(el).css("border-right","1px solid #2a85a0");
                break;
            case 1:
                $(el).css("border-right","1px solid #2a85a0");
                break;
            case 2:
                break;
        }
    })
}