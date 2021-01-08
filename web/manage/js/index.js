window.onload=function (){
    init();
}
function init(){
    $(".icon-sel").each(function (index,el) {
        $(el).click(function () {
            switch(index){
                case 0:
                    $("#iframe-contains").attr('src',"goodsList.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span>/商品管理</span>")
                    break;
                case 1:
                    $("#iframe-contains").attr('src',"orderMang.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/订单管理</span>")
                    break;
                case 2:
                    $("#iframe-contains").attr('src',"sortMang.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/分类管理</span>")
                    break;
                case 3:
                    $("#iframe-contains").attr('src',"messMang.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/留言管理</span>")
                    break;
                case 4:
                    $("#iframe-contains").attr('src',"comtMang.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/评论管理</span>")
                    break;
                case 5:
                    $("#iframe-contains").attr('src',"fridLink.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/友情链接</span>")
                    break;
                case 6:
                    $("#iframe-contains").attr('src',"adMang.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/广告管理</span>")
                    break;
                case 7:
                    $("#iframe-contains").attr('src',"systemSet.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/系统设置</span>")
                    break;
                case 8:
                    $("#iframe-contains").attr('src',"clearCache.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/缓存清理</span>")
                    break;
                case 9:
                    $("#iframe-contains").attr('src',"dataBack.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/数据备份</span>")
                    break;
                case 10:
                    $("#iframe-contains").attr('src',"reData.jsp");
                    $("#navLocation").html("<span class='firstP'>首页</span><span>/数据还原</span>")
                    break;
                default:
                    $("#iframe-contains").attr('src',"welcome.jsp");
                    $("#navLocation").html("<i class=\"icon-font\">&#xe06b;</i><span>欢迎使用 Breeze商城。</span>")
                    break;
            }

        })
    })
    $(".welcomePage").click(function () {
        $("#iframe-contains").attr('src',"welcome.jsp");
        $("#navLocation").html("<i class=\"icon-font\">&#xe06b;</i><span>欢迎使用 Breeze商城。</span>")
    })
}