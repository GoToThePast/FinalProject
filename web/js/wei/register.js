$(function () {
    let registerTypes= $(".type");
    let registerCont= $(".registerCont");
    registerTypes.on("click",function () {
        let ts = $(this);
        ts.addClass("selected");
        ts.children(".registerCont").addClass("selectCont");
        ts.siblings().removeClass("selected");
        ts.siblings().children(".registerCont").removeClass("selectCont");
    })
})