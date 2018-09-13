<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>test</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.js" ></script>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    <script type="text/javascript" src="../js/jquery-3.2.1.js" ></script>

    <script type="text/javascript">
        $(function () {
            console.log('123')
        });

    </script>
    <style type="text/css" rel="stylesheet">
        body{
            padding-left: 150px;
            padding-right: 150px;
        }
        li{
            list-style-type:none;
        }
        .nav li{
            text-align: center;
        }

        .mid{
            float: right;
            padding-right: 50px;
        }

        .right{
            padding-right: 200px;
        }

        .foot-title{
            color: #ffffff;
        }

        .foot-content{
            color: #878787;
        }

        .page-footer{
            background-color: #252a33;
        }

        .copy-right{
            background-color: #20252e;
        }

        .carousel{
            margin-left: -150px;
            margin-right: -150px;
            z-index: 0;
        }
        .minicate{
            width: 100%;
            background-color: white;
            position: absolute;
            z-index: 150;
            margin-right: -150px;
            margin-left: -150px;
            margin-top: -30px;
            display: none;
        }
        .navDrop{
            display: none;
            position: absolute;
            z-index: 150;
            background-color: white;
            width: 100%;
        }
        .navDrop li{
            text-align: left;
        }

        .page-footer{
            margin-right: -150px;
            margin-left: -150px;
        }
        .copy-right{
            margin-right: -150px;
            margin-left: -150px;
        }
    </style>
</head>
<body >

<#--页头-->
<div class="page-header">
    <nav class="navbar navbar-default">
    <#--简易设置间距-->
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <#--LOGO-->
                <div class="left navbar-left"><h1>Logo</h1></div>

                <#--登录-->
                    <div class="right navbar-right">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        <h5>sign in/sign up</h5>
                    </div>

                <#--中间-->
                <div class="mid">
                    <div class="mid-text">
                        <span class="glyphicon glyphicon-earphone" aria-hidden="true">12345678</span>
                        <span class="glyphicon glyphicon-time" aria-hidden="true">7days a week from 9:00 am to 7:0pm</span>
                    </div>
                    <div class="search-box">
                        <form class="navbar-form ">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                    </div>
                </div>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <ul class="nav nav-tabs">
        <ul class="nav nav-tabs nav-justified">
            <li>Home</li>
            <li ><div onmouseover="$('.minicate').show()" onmouseleave="$('.minicate').hide()">Products</div></li>
            <li>
                <div onmouseover="$('#caseDrop').show()" onmouseleave="$('#caseDrop').hide()">Case</div>
                <div class="navDrop" id="caseDrop" onmouseover="$('#caseDrop').show()" onmouseleave="$('#caseDrop').hide()">
                    <ul>
                        <li>Interior</li>
                        <li>Exterior</li>
                        <li>Performance</li>
                        <li>Lighting</li>
                        <li>Wheels & Tires</li>
                        <li>Floor Mats</li>
                    </ul>
                </div>
            </li>
            <li>
                <div onmouseover="$('#aboutUsDrop').show()" onmouseleave="$('#aboutUsDrop').hide()">About us</div>
                <div class="navDrop" id="aboutUsDrop" onmouseover="$('#aboutUsDrop').show()" onmouseleave="$('#aboutUsDrop').hide()">
                    <ul>
                        <li>About Us</li>
                        <li>Company Technology</li>
                        <li>Company Honor</li>
                        <li>Bedroom Furniture</li>
                    </ul>
                </div>
            </li>
            <li>News</li>
            <li>Contact Us</li>
            <li><span class="badge">4</span>Inquiry Cart</li>
        </ul>
    </ul>
</div>
<#--微型的商品分类-->
<div class="minicate" onmouseover="$('.minicate').show()" onmouseleave="$('.minicate').hide()">
    <div class=" container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="row">
                    <div class="col-md-6">
                        <img alt="140x140" src="../categories-img/Categories1.jpg" width="140px" height="140px"/>
                    </div>
                    <div class="col-md-6">
                        <ul>
                            <li>
                                <a href="#">Interior</a>
                            </li>
                            <li>
                                Dash Kits
                            </li>
                            <li>
                                Floor Mats
                            </li>
                            <li>
                                SeatCovers
                            </li>
                            <li>
                                Steering Wheels
                            </li>
                            <li>
                                Show All
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <img alt="140x140" src="../categories-img/Categories4.jpg" width="140px" height="140px"/>
                    </div>
                    <div class="col-md-6">
                        <ul>
                            <li>
                                Lighting
                            </li>
                            <li>
                                Headlights
                            </li>
                            <li>
                                Tail Lights
                            </li>
                            <li>
                                LED Lights
                            </li>
                            <li>
                                Fog Lights
                            </li>
                            <li>
                                Show All
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="row">
                    <div class="col-md-6">
                        <img alt="140x140" src="../categories-img/Categories2.jpg" width="140px" height="140px"/>
                    </div>
                    <div class="col-md-6">
                        <ul>
                            <li>
                                <a href="#">Interior</a>
                            </li>
                            <li>
                                Dash Kits
                            </li>
                            <li>
                                Floor Mats
                            </li>
                            <li>
                                SeatCovers
                            </li>
                            <li>
                                Steering Wheels
                            </li>
                            <li>
                                Show All
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <img alt="140x140" src="../categories-img/Categories5.jpg" width="140px" height="140px"/>
                    </div>
                    <div class="col-md-6">
                        <ul>
                            <li>
                                Lighting
                            </li>
                            <li>
                                Headlights
                            </li>
                            <li>
                                Tail Lights
                            </li>
                            <li>
                                LED Lights
                            </li>
                            <li>
                                Fog Lights
                            </li>
                            <li>
                                Show All
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="row">
                    <div class="col-md-6">
                        <img alt="140x140" src="../categories-img/Categories3.jpg" width="140px" height="140px"/>
                    </div>
                    <div class="col-md-6">
                        <ul>
                            <li>
                                <a href="#">Interior</a>
                            </li>
                            <li>
                                Dash Kits
                            </li>
                            <li>
                                Floor Mats
                            </li>
                            <li>
                                SeatCovers
                            </li>
                            <li>
                                Steering Wheels
                            </li>
                            <li>
                                Show All
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <img alt="140x140" src="../categories-img/Categories6.jpg" width="140px" height="140px"/>
                    </div>
                    <div class="col-md-6">
                        <ul>
                            <li>
                                Lighting
                            </li>
                            <li>
                                Headlights
                            </li>
                            <li>
                                Tail Lights
                            </li>
                            <li>
                                LED Lights
                            </li>
                            <li>
                                Fog Lights
                            </li>
                            <li>
                                Show All
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <h5>Recommend Products</h5>
                <div><button class="btn btn-success">View More</button></div>
                <div><img src="../categories-img/Categories1.jpg"/></div>
            </div>
        </div>
    </div>
</div>

<!-- 导航区 -->
<#--<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">Home</a></li>
    <li role="presentation"><a href="#profile" role="tab" data-toggle="tab">Profile</a></li>
    <li role="presentation"><a href="#messages" role="tab" data-toggle="tab">Messages</a></li>
    <li role="presentation"><a href="#settings" role="tab" data-toggle="tab">Settings</a></li>
</ul>-->
<!-- 面板区 -->
<#--<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">...</div>
    <div role="tabpanel" class="tab-pane " id="profile"></div>
    <div role="tabpanel" class="tab-pane" id="messages">...</div>
    <div role="tabpanel" class="tab-pane" id="settings">...</div>
</div>-->
<#--轮播图组件-->
<div class="carousel slide" id="carousel-18944">
    <ol class="carousel-indicators">
        <li class="active" data-slide-to="0" data-target="#carousel-18944"></li>
        <li data-slide-to="1" data-target="#carousel-18944" class=""></li>
        <li data-slide-to="2" data-target="#carousel-18944" class=""></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active"> <img alt="" src="../carousel-img/carousel1.jpg">
            <div class="carousel-caption" contenteditable="true">
                <h4>便宜！</h4>
                <p>只要一元，统统一元，一元买不了吃亏，一元买不了上当，错过这家，没有下家！</p>
            </div>
        </div>
        <div class="item"> <img alt="" src="../carousel-img/carousel2.jpg">
            <div class="carousel-caption" contenteditable="true">
                <h4>质量！</h4>
                <p>这么帅的小车车见过没？高端大气上档次，低调奢华有内涵！</p>
            </div>
        </div>
        <div class="item"> <img alt="" src="../carousel-img/carousel3.jpg">
            <div class="carousel-caption" contenteditable="true">
                <h4>优惠！</h4>
                <p>奔驰，宝马，奥迪，兰博基尼，三元一辆，十元三辆！</p>
            </div>
        </div>
    </div>
    <a data-slide="prev" href="#carousel-18944" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-18944" class="right carousel-control">›</a>
</div>

<#--商品分类-->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h3>
                Popular Categories
            </h3>
            <div class="row">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <img alt="140x140" src="../categories-img/Categories1.jpg" />
                        </div>
                        <div class="col-md-6">
                            <ul>
                                <li>
                                    <a href="#">Interior</a>
                                </li>
                                <li>
                                    Dash Kits
                                </li>
                                <li>
                                    Floor Mats
                                </li>
                                <li>
                                    SeatCovers
                                </li>
                                <li>
                                    Steering Wheels
                                </li>
                                <li>
                                    Show All
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <img alt="140x140" src="../categories-img/Categories2.jpg" />
                        </div>
                        <div class="col-md-6">
                            <ul>
                                <li>
                                    Exterior
                                </li>
                                <li>
                                    Running Boards
                                </li>
                                <li>
                                    Custom Grilles
                                </li>
                                <li>
                                    Chrome Trim
                                </li>
                                <li>
                                    Body Kits
                                </li>
                                <li>
                                    Show all
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <img alt="140x140" src="../categories-img/Categories3.jpg" />
                        </div>
                        <div class="col-md-6">
                            <ul>
                                <li>
                                    Performance
                                </li>
                                <li>
                                    Exhaust Systems
                                </li>
                                <li>
                                    Brakes
                                </li>
                                <li>
                                    Suspension Systems
                                </li>
                                <li>
                                    Air Intake Systems
                                </li>
                                <li>
                                    Show all
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <img alt="140x140" src="../categories-img/Categories4.jpg" />
                        </div>
                        <div class="col-md-6">
                            <ul>
                                <li>
                                    Lighting
                                </li>
                                <li>
                                    Headlights
                                </li>
                                <li>
                                    Tail Lights
                                </li>
                                <li>
                                    LED Lights
                                </li>
                                <li>
                                    Fog Lights
                                </li>
                                <li>
                                    Show All
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <img alt="140x140" src="../categories-img/Categories5.jpg" />
                        </div>
                        <div class="col-md-6">
                            <ul>
                                <li>
                                    Wheels & Tires
                                </li>
                                <li>
                                    Caliper Covers
                                </li>
                                <li>
                                    TPMS Sensors
                                </li>
                                <li>
                                    Lug Nuts & Locks
                                </li>
                                <li>
                                    Wheel Center Caps
                                </li>
                                <li>
                                    Show all
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <img alt="140x140" src="../categories-img/Categories6.jpg" />
                        </div>
                        <div class="col-md-6">
                            <ul>
                                <li>
                                    Audio & Electronics
                                </li>
                                <li>
                                    Installation Parts
                                </li>
                                <li>
                                    Stereos
                                </li>
                                <li>
                                    Speakers
                                </li>
                                <li>
                                    Amplifiers
                                </li>
                                <li>
                                    Show all
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#--流行商品-->
<div class="container-fluid">
    <h3>
        Popular Products
    </h3>
    <div class="row">
        <div class="col-md-3">
            <div>
                <img alt="140x140" src="../popular-img/popular1.jpg" />
                <p>Wilwood® - Street Performance Drilled and Slotted Brake Kit</p>
            </div>
        </div>
        <div class="col-md-3">
            <div>
                <img alt="140x140" src="../popular-img/popular2.jpg" />
                <p>Braum® - Elite-X Sport Seats</p>
            </div>
        </div>
        <div class="col-md-3">
            <div>
                <img alt="140x140" src="../popular-img/popular3.jpg" />
                <p>KSport® - SuperComp Cross Drilled Brake Kit</p>
            </div>
        </div>
        <div class="col-md-3">
            <div>
                <img alt="140x140" src="../popular-img/popular4.jpg" />
                <p>Go Rhino® - 3" 4000 Series Round 1-Piece Design Side Steps</p>
            </div>
        </div>
    </div>
</div>

<#--Modificaiton case-->
<div class="container-fluid">
    <h3>
        Modification Case
    </h3>
    <div class="row">
        <div class="col-md-3">
            <img alt="140x140" src="../modi-img/Modi1.jpg" />
            <img alt="140x140" src="../modi-img/Modi3.jpg" />
        </div>
        <div class="col-md-6">
            <img alt="140x140" src="../modi-img/Modi5.jpg" />
        </div>
        <div class="col-md-3">
            <img alt="140x140" src="../modi-img/Modi2.jpg" />
            <img alt="140x140" src="../modi-img/Modi4.jpg" />
        </div>
    </div>
</div>

<#--latest news-->
<div class="container-fluid">
    <h3>
        Latest News
    </h3>
    <div class="row">
        <div class="col-md-4"><img alt="news" src="../news-img/News1.jpg"></div>
        <div class="col-md-8">
            <div class="news-title">Recaro Automotive Seating Announces Partnership with Onyx Enterprises' CAR ID/div>
            <div class="news-date">Aug . 07 . 2018</div>
            <div class="news-content">
                LAS VEGAS, Nov. 2, 2017 /PRNewswire/ -- Recaro Automotive Seating announced that beginning on "Black Friday," November 24, 2017, the premium brand's products will be available for purchase on Onyx Enterprises' CAR ID site. CAR ID is a premier marketer of
            </div>
            <div class="news-btn">
                <button type="button" class="btn btn-success">View More</button>
            </div>
        </div>
        </div>
    </div>
</div>

<#--Page-footer-->
<div class="page-footer container-fluid">
    <div class="col-md-6">
        <h5 class="foot-title">About Us</h5>
        <p class="foot-content">Our store offers all car enthusiasts the largest selection of analogue auto parts for any car. When buying spare car parts you will benefit and make sure the quality of all auto parts is beyond expectations.</p>
    </div>
    <div class="col-md-2">
        <h5 class="foot-title">Products</h5>
        <p class="foot-content">123</p>
    </div>
    <div class="col-md-2">
        <h5 class="foot-title">About Us</h5>
        <p class="foot-content">456</p>
    </div>
    <div class="col-md-2">
        <h5 class="foot-title">Contact Us</h5>
        <p class="foot-content">789</p>
    </div>
</div>
<div class="copy-right">
    <p class="foot-title">UEESHOP © All Rights Reserved.</p>
</div>
</body>
</html>