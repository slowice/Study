<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>tempalte</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.js" ></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    <script type="text/javascript" src="../js/jquery-3.2.1.js" ></script>

    <script type="text/javascript">
        $(function() {
            $(".content").mouseover(function () {
                $(this).stop().animate({
                    width: "100px"
                }).mouseout(function () {
                    $(this).stop().animate({
                        width: "10px"
                    });
                });
            });
        }
    </script>
    <style type="text/css" rel="stylesheet">
        .content{
            width:10px;
            height:100px;
            border:1px solid black;
            float: right;
            top:200px;
            position:relative;
        }
    </style>
</head>
<body >
<div class='content' />
</body>
</html>