<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--<meta http-equiv="cache-control" content="no-cache">-->
    <!--<meta http-equiv="Cache-Control" content="max-age=7200" />-->
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.js" ></script>
    <script type="text/javascript">
        $(function () {
            console.log('123')
            // dataFilter();
        });

        function dataFilter(){
            var Book = {};
            var name = '';
            Object.defineProperty(Book,'name',{
                get:function () {
                    return '《'+name+'》'
                },
                set:function (value) {
                    name = value;
                    console.log("书名是"+name)
                }
            });
            Book.name = '腰椎间盘突出'
        }

        function testHref(){
            window.location = "https://www.baidu.com";
        }
    </script>
</head>
<body>
    this is test.ftl  123
    <span><button onclick="window.location.href='https://www.baidu.com'" ></button></span>

    <span><a href="/www.baidu.com">hehe</a></span>

    <div><button onclick="testHref()">test</button></div>
</body>
</html>