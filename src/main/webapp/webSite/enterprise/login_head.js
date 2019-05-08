<!-- Ace Responsive Menu -->

document.writeln('<header class="header-nav style_one navbar-scrolltofixed main-menu">');
document.writeln('<div class="container">');
document.writeln('<nav>');
document.writeln('');	<!-- Menu Toggle btn-->
document.writeln('<div class="menu-toggle">');
document.writeln('<img class="nav_logo_img img-fluid" src="../images/header-logo.png" alt="../images/header-logo.png">');
document.writeln('<button type="button" id="menu-btn">');
document.writeln('<span class="icon-bar"></span>');
document.writeln('<span class="icon-bar"></span>');
document.writeln('<span class="icon-bar"></span>');
document.writeln('</button>');
document.writeln('</div>');
document.writeln('<a href="../findJob.html" style="width: 6%;" class="navbar_brand float-left dn-smd">');
document.writeln('<img class="img-fluid mt10"  src="/static/common/image/hdrc.jpg" alt="../images/header-logo.png">');
document.writeln('</a>');
document.writeln('');	<!-- Responsive Menu Structure-->
document.writeln('');	<!--Note: declare the Menu style in the data-menu-style="horizontal" (options: horizontal, vertical, accordion) -->
document.writeln('<ul id="respMenu" class="ace-responsive-menu" data-menu-style="horizontal">');
document.writeln('<li>');
document.writeln('<a href="javascript:;"  onclick="jumpFindJob()"><span class="title">找工作</span></a>');
document.writeln('');			<!-- Level Two-->
document.writeln('</li>');
document.writeln('<li>');
document.writeln('<a href="javascript:;" onclick="jumpFindResume()"><span class="title">找人才</span></a>');
document.writeln('');			<!-- Level Two-->
document.writeln('</li>');
document.writeln('<li class="last">');
document.writeln('<a href="javascript:;" onclick="jumpGathering()"><span class="title">企业会员充值</span></a>');
document.writeln('</li>');
document.writeln('</ul>');
// document.writeln('<ul class="sign_up_btn pull-right dn-smd mt10">');
// document.writeln('<li><a href="#" class="btn btn-md" data-toggle="modal" data-target="#exampleModalCenter" onclick="jumpLogin()">登<span class="dn-md">入</span>/注<span class="dn-md">册</span></a></li>');
// document.writeln('</ul>');	<!-- Button trigger modal -->
if(JSON.parse(localStorage.getItem("enterprise"))==null){
    document.writeln('<ul class="sign_up_btn pull-right dn-smd mt10">');
    document.writeln('<li><a href="#" class="btn btn-md" data-toggle="modal" data-target="#exampleModalCenter" onclick="jumpLogin()">企业登入/企业注册</a></li>');
    document.writeln('</ul>');	<!-- Button trigger modal -->
}else{
    document.writeln('<ul class="header_user_notif pull-right dn-smd">');
    document.writeln('<li class="user_setting">');
        document.writeln('<div class="dropdown">');
        if(app.enterpriseLogo==null){
            document.writeln('<a class="btn dropdown-toggle" href="#" data-toggle="dropdown"><img class="rounded-circle" src="/static/upload/image/blank.jpg" alt="8.jpg"> <span class="pl15 pr15" style="width:100px;margin-top:10%;">{{enterpriseName}}</span></a>');
        }else{
            document.writeln('<a class="btn dropdown-toggle" href="#" data-toggle="dropdown"><img class="rounded-circle" :src="\'/\'+enterpriseLogo" alt="8.jpg"> <span class="pl15 pr15" style="width:100px;margin-top:10%;">{{enterpriseName}}</span></a>');
        }
    document.writeln('<div class="dropdown-menu">');
        document.writeln('<div class="user_setting_content">');
        document.writeln('<a class="dropdown-item" onclick="jumpEnterprise();" href="javascript:;"><span class="flaticon-locked"></span> 企业中心</a>');
    document.writeln('<a class="dropdown-item" onclick="jumpLogout();" href="javascript:;"><span class="flaticon-logout"></span> 退出</a>');
    document.writeln('</div>');
    document.writeln('</div>');
    document.writeln('</div>');
    document.writeln('</li>');
    document.writeln('</ul>');
}




document.writeln('</nav>');
document.writeln('</div>');
document.writeln('</header>');
<!-- End of Responsive Menu -->