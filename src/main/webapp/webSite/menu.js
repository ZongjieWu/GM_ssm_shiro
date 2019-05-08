	<!-- Responsive Menu Structure-->
    document.writeln('<div class="col-sm-12 col-lg-4 col-xl-3 dn-smd">');
        document.writeln('<div class="dashbord_nav_list">');
        document.writeln('<ul>');
    document.writeln('<li class="active"><a href="javascript:;"><span class="flaticon-dashboard"></span> 首页</a></li>');
    document.writeln('<li  onclick="jumpSelfAuthentication();"><a target="user" href="javascript:;"><img src="images/menuIcon/authentication.png" style="width: 8%;"> 个人认证</a></li>');
    document.writeln('<li  onclick="jumpUserInfo();"><a target="user" href="javascript:;"><img src="images/menuIcon/data.png" style="width: 8%;"> 个人资料</a></li>');
    document.writeln('<li onclick="jumpUserResumePreview();"><a target="user" href="javascript:;"><img src="images/menuIcon/preview.png" style="width: 8%;"> 预览简历</a></li>');
    document.writeln('<li onclick="jumpUpdateResume();"><a target="user" href="javascript:;"><img src="images/menuIcon/edit.png" style="width: 8%;"> 编辑简历</a></li>');
    document.writeln('<li onclick="jumpSendRecord();"><a target="user" href="javascript:;"><img src="images/menuIcon/send.png" style="width: 8%;"> 投递记录</a></li>');
    // document.writeln('<li><a target="user" href="javascript:;"><span class="flaticon-favorites"></span> 职位收藏</a></li>');
    document.writeln('<li onclick="jumpInterViewNotify();"><a target="user" href="javascript:;"><img src="images/menuIcon/notify.png" style="width: 8%;"> 面试通知</a></li>');
    document.writeln('<li onclick="jumpUpdatePwd();"><a target="user" href="javascript:;"><img src="images/menuIcon/modifyPwd.png" style="width: 8%;"> 修改密码</a></li>');
    document.writeln('</ul>');
    document.writeln('</div>');
    document.writeln('</div>');