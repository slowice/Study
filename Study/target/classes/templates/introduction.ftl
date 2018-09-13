<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>tempalte</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.js" ></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <script type="text/javascript">
        function Product(){
            var title;
            var img_src;
        }
        
        $(function () {
            var prodArr = new Array();

            for(var i=1;i<=12;i++){
                var product = new Product();
                product.title = "COKER® - EXCELSIOR 1 1/2 INCH WHITEWALL";
                product.img_src = "../prodList-img/" + i + ".jpg";
                prodArr.push(product)
            }


            for(var i in prodArr){
                var prod =  prodArr[i];
                var img =  '<img class="list_img" src=" '+ prod.img_src +' " >'
                $('.img_box').append(img)
            }

           // $('#prod1_img').attr("src",product1.img_src)
            //$('#prod1_title').html(product1.title)
            //var imgDiv =

        })
    </script>
    <style type="text/css" rel="stylesheet">
        .panel-collapse ul{
            list-style: none;
        }
        .panel-group{
            width: 20.42%;
        }
        .panel-group{
            float: left;
        }
        .list_img{
            width: 33%;
        }
        .img_box{
            width: 75%;
            float: right;
        }
    </style>
</head>
<body >
<div>
<#--左侧折叠栏-->
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne">
                        Interior
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                    <ul>
                        <li>1</li>
                        <li>2</li>
                        <li>3</li>
                        <li>4</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTwo">
                        Exterior
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                    Nihil anim keffiyeh helvetica, craft beer labore wes anderson
                    cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
                    vice lomo.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseThree">
                        点击我进行展开，再次点击我进行折叠。第 3 部分
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    Nihil anim keffiyeh helvetica, craft beer labore wes anderson
                    cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
                    vice lomo.
                </div>
            </div>
        </div>
    </div>

<#--图片展示栏-->
    <#--<div class="prodImg container-fluid">
        <div class="row">
            <div class="col-md-4">
                <img id="prod1_img">
                <p id="prod1_title"></p>
                <button class="btn btn-success">View More</button>
            </div>
            <div class="col-md-4">2</div>
            <div class="col-md-4">3</div>
        </div>
    </div>-->
    <div class="img_box">

    </div>
</div>

</body>
</html>