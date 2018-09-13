<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>template</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.js" ></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    <script type="text/javascript" src="../js/jquery-3.2.1.js" ></script>

    <script type="text/javascript">
        //菜单的动画效果
        function showSMenu() {
            $('.menu_text').stop().animate({width:"0px"})
            $('.menu_text_child').stop().animate({width:"130px"})
        }
        function showFMenu() {
            $('.menu_text').stop().animate({width:"130px"})
            $('.menu_text_child').stop().animate({width:"0px"})
        }

        //菜单的鼠标移动效果
        function initTextColorEvent() {
            $('.menu_icon li').mouseover(function () {
                if($(this).hasClass('selected')){
                    return;
                }
                $(this).addClass('active')
                var _index = $(this).index()
                $('.menu_text li:eq('+_index+')').addClass('active')
            })

            $('.menu_icon li').mouseleave(function () {
                $(this).removeClass('active')
                var _index = $(this).index()
                $('.menu_text li:eq('+_index+')').removeClass('active')
            })

            $('.menu_text ol li').mouseover(function () {
                $(this).addClass("active")
            })

            $('.menu_text ol li').mouseleave(function () {
                $(this).removeClass("active")
            })

            $('.menu_outer').on("mouseover","li",function () {
                $(this).addClass("active")
            })

            $('.menu_outer').on("mouseleave","li",function () {
                $(this).removeClass("active")
            })
        }
        function initChildMenuEvent() {
            $('.menu_icon').on("mouseover",".selected",function () {
                showSMenu();
            })
            $('.menu_icon').on("mouseleave",".selected",function () {
                showFMenu();
            })
            $('.menu_outer').on("mouseover",".menu_text_child",function () {
                showSMenu();
            })
            $('.menu_outer').on("mouseleave",".menu_text_child",function () {
                showFMenu();
            })
        }

        $(function(){
            initTextColorEvent();
            initChildMenuEvent();
            if($('.menu_text_child p').text().trim()){
                $('.menu_text').css("width","0px")
                $('.menu_text_child').css("width","130px")
                $('.menu_icon li:eq('+$('#index').val()+')').addClass('active')
                $('.menu_icon li:eq('+$('#index').val()+')').addClass('selected')
                $('.menu_text_child li:eq('+$('#sIndex').val()+')').addClass('active')
            }
            //菜单图标的点击事件
            /*$('.menu_icon li').click(function () {
                $(this).parents().find('.selected').removeClass("selected")
                $(this).addClass('selected') //利用active在notactive下方，所以只需要控制active来覆盖notactive
                //设置子菜单文本
                var id = $(this).index();
                var name = $('.menu_text li:eq('+ id +')').text();
                $('.menu_text_child p').text(name);
                $.ajax({
                    type:'POST',
                    url:'manage/getSMenu',
                    data:{"id":id+1},
                    success:function (data) {
                        $('.menu_text_child ol li').remove();
                        for(var i in data){
                            var prodli = "<li>"+ data[i].name+"</li>";
                            $('.menu_text_child ol').append(prodli);
                        }
                        showSMenu();
                    }
                })
            })*/
        })
    </script>

    <style type="text/css" rel="stylesheet">
        body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, button, textarea, p, blockquote, table, th, td {margin:0; padding:0;}

        .menu_outer{
            height: 100%;
            width: 170px;
            background-color: #1f1f20;
            position: fixed;
        }

        .menu_icon{
            width: 40px;
            float: left;
        }

        .menu_icon li span{
            height: 40px;
            color: grey;
        }

        .menu_text{
             width: 130px;
             position: absolute;
             margin-left: 40px;
         }

        .menu_text li{
            list-style-type: none;
            height: 40px;
            overflow: hidden;
            white-space: nowrap;
            color: grey;
        }

        .menu_text_child{
            width: 0px;
            position: relative;
            float: right;
            background-color: #333336;
            height: 100%;
        }

        /*子菜单标题*/
        .menu_text_child p{
            padding: 30px 0 18px 25px;
            font-size: 19px;
            height: auto;
            color: white;
            overflow: hidden;
            /*文字在动画效果中不会被挤换行*/
            white-space: nowrap;
        }
        /*子菜单文本*/
        .menu_text_child li{
            padding-left: 25px;
            list-style-type: none;
            height: 38px;
            color: white;
            overflow: hidden;
            white-space: nowrap;
        }

        .active{
            color: #07bb8a!important;
        }
        .active span{
            color: #07bb8a!important;
        }
        .selected span{
            color: #07bb8a!important;
        }
    </style>
</head>
<body >
    <input id="index" type="hidden" value="${index!}">
    <input id="sIndex" type="hidden" value="${sIndex!}">

    <div class="menu_outer">
        <div class="menu menu_icon">
            <ol style="list-style: none">
                <li class="notactive"><span class="glyphicon glyphicon-asterisk " aria-hidden="true"></span></li>
                <li class="notactive"><a href="manage?m=products&&a=products"><span class="glyphicon glyphicon-asterisk " aria-hidden="true"></span></a></li>
                <li class="notactive"><span class="glyphicon glyphicon-asterisk " aria-hidden="true"></span></li>
                <li class="notactive"><span class="glyphicon glyphicon-asterisk " aria-hidden="true"></span></li>
                <li class="notactive"><span class="glyphicon glyphicon-asterisk " aria-hidden="true"></span></li>
                <li class="notactive"><span class="glyphicon glyphicon-asterisk " aria-hidden="true"></span></li>
                <li class="notactive"><span class="glyphicon glyphicon-asterisk " aria-hidden="true"></span></li>
                <li class="notactive"><span class="glyphicon glyphicon-asterisk " aria-hidden="true"></span></li>
                <li class="notactive"><span class="glyphicon glyphicon-asterisk " aria-hidden="true"></span></li>
            </ol>
        </div>

        <div class="menu menu_text">
            <ol>
                <#list menuList as menu>
                    <li>${menu.name}</li>
                </#list>
            </ol>
        </div>

        <div class="menu menu_text_child">
            <p>${title!}</p>
            <ol>
            <#list sMenuList! as sMenu>
                <li>${sMenu.name}</li>
            </#list>
            </ol>
        </div>
    </div>
</body>
</html>