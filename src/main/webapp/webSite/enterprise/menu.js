	<!-- Responsive Menu Structure-->
    document.writeln('<div class="col-sm-12 col-lg-4 col-xl-3 dn-smd">');
        document.writeln('<div class="dashbord_nav_list">');
        document.writeln('<ul>');
    document.writeln('<li class="active" onclick="jumpAccountInfo();"><a href="javascript:;"><span class="flaticon-dashboard"></span> 首页</a></li>');
    document.writeln('<li  onclick="jumpSelfAuthentication();"><a target="user" href="javascript:;"><img src="../images/menuIcon/authentication.png" style="width: 8%;"> 企业认证</a></li>');
    document.writeln('<li  onclick="jumpAccountInfo();"><a target="user" href="javascript:;"><img src="../images/menuIcon/info.png" style="width: 8%;"> 账号信息</a></li>');
    document.writeln('<li  onclick="jumpRecieveResume();"><a target="user" href="javascript:;"><img src="../images/menuIcon/receive.png" style="width: 8%;"> 查收简历</a></li>');
    document.writeln('<li onclick="jumpFindResume();"><a target="user" href="javascript:;"><img src="../images/menuIcon/search.png" style="width: 8%;"> 搜索简历</a></li>');
    document.writeln('<li onclick="jumpJobList();"><a target="user" href="javascript:;"><img src="../images/menuIcon/send.png" style="width: 8%;"> 发布职位</a></li>');
    document.writeln('<li onclick="jumpInterViewNotify();"><a target="user" href="javascript:;"><img src="../images/menuIcon/notify.png" style="width: 8%;"> 面试通知</a></li>');
    // document.writeln('<li><a target="user" href="javascript:;"><span class="flaticon-favorites"></span> 简历收藏</a></li>');
    document.writeln('<li  onclick="jumpEnterpriseInfo();"><a target="user" href="javascript:;"><img src="../images/menuIcon/data.png" style="width: 8%;"> 企业资料</a></li>');
    document.writeln('<li  onclick="jumpUpdatePwd();"><a target="user" href="javascript:;"><img src="../images/menuIcon/modifyPwd.png" style="width: 8%;"> 修改密码</a></li>');

    document.writeln('</ul>');
    document.writeln('</div>');
    document.writeln('</div>');