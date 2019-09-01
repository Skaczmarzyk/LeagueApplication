$(function(){

    var splashRight=$("#rigthSplash");
    var splashLeft=$("#leftSplash");
    var champion1div=$("#champion1");
    var champion2div=$("#champion2");
    if(splashRight.attr("src").substr(splashRight.attr("src").length-3,3) !="jpg")
    {
        champion2div.hide();
    }
    if(splashLeft.attr("src").substr(splashLeft.attr("src").length-3,3) !="jpg")
    {
        champion1div.hide();
    }

})
