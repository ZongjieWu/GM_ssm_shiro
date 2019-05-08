// function authenticationEnterprise(){
//     var isAuthentication=false;
//     var data={};
//     data.id=JSON.parse(localStorage.getItem("enterprise")).id;
//     $.ajaxSettings.async = false;
//     $.post("/api/enterprise/detail",data,function(res){
//         //第一个认证的
//         if(res.data.authenticationStatus==0){
//             alert("请认证");
//             isAuthentication=false;
//         }else if(res.data.authenticationStatus==1){
//             alert("请等待认证");
//             isAuthentication=false;
//         }else if(res.data.authenticationStatus==2){
//             alert("请等待认证");
//             isAuthentication=true;
//         }else if(res.data.authenticationStatus==3){
//             alert("认证失败,请重新认证");
//             isAuthentication=false;
//         }
//     });
//     $.ajaxSettings.async = true;
//     alert(isAuthentication);
//     return isAuthentication;
// }

function jumpSelfAuthentication() {
    $("#enterprise").attr("src","authentication.html");
}
function jumpRemitRecord() {
        window.location.href="remitRecord.html";

}
function jumpGathering() {
        window.location.href="dashboard.html";
}
function jumpJobList() {
    var isAuthentication=false;
    var errMsg="";
    var authenticationStatus=0;
    var data={};
    data.id=JSON.parse(localStorage.getItem("enterprise")).id;
    $.ajaxSettings.async = false;
    $.post("/api/enterprise/detail",data,function(res){
        console.log(res.data);
        authenticationStatus=res.data.authenticationStatus;
        //第一个认证的
        if(res.data.authenticationStatus==0){
            errMsg="请认证";
            isAuthentication=false;
        }else if(res.data.authenticationStatus==1){
            errMsg="请等待认证";
            isAuthentication=false;
        }else if(res.data.authenticationStatus==2){
            //判断是否到期
            Date.prototype.Format = function (fmt) { //author: meizz
                var o = {
                    "M+": this.getMonth() + 1,                 //月份
                    "d+": this.getDate(),                    //日
                    "h+": this.getHours(),                   //小时
                    "m+": this.getMinutes(),                 //分
                    "s+": this.getSeconds(),                 //秒
                    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                    "S": this.getMilliseconds()             //毫秒
                };
                if (/(y+)/.test(fmt))
                    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                for (var k in o)
                    if (new RegExp("(" + k + ")").test(fmt))
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                return new Date(fmt);
            }

            var data = (new Date()).Format("yyyy-MM-dd");
            if (new Date(res.data.serviceEndTime) < new Date(data)) {
                alert("请到首页企业充值页面续费后操作");
                window.location.href="dashboard.html";
            }
            isAuthentication=true;
        }else if(res.data.authenticationStatus==3){
            errMsg="认证失败,请重新认证";
            isAuthentication=false;
        }
    });
    $.ajaxSettings.async = true;
    if(isAuthentication){
        $("#enterprise").attr("src","jobList.html");
    }else{
        alert(errMsg);
        if(authenticationStatus==0||authenticationStatus==3){
            $("#enterprise").attr("src","authentication.html");
        }
    }

}
function jumpFindJob() {
        window.location.href="../findJob.html"
}

function jumpUpdatePwd() {
    $("#enterprise").attr("src","forgetPassword.html");
}
function jumpLogin() {
    window.location.href="login.html";
}
function jumpLogout() {
    localStorage.removeItem("enterprise");
    window.location.href="login.html";
}
function jumpRecieveResume() {
    var isAuthentication=false;
    var errMsg="";
    var authenticationStatus=0;
    var data={};
    data.id=JSON.parse(localStorage.getItem("enterprise")).id;
    $.ajaxSettings.async = false;
    $.post("/api/enterprise/detail",data,function(res){
        console.log(res.data);
        authenticationStatus=res.data.authenticationStatus;
        //第一个认证的
        if(res.data.authenticationStatus==0){
            errMsg="请认证";
            isAuthentication=false;
        }else if(res.data.authenticationStatus==1){
            errMsg="请等待认证";
            isAuthentication=false;
        }else if(res.data.authenticationStatus==2){
            //判断是否到期
           Date.prototype.Format = function (fmt) { //author: meizz
               var o = {
                   "M+": this.getMonth() + 1,                 //月份
                   "d+": this.getDate(),                    //日
                   "h+": this.getHours(),                   //小时
                   "m+": this.getMinutes(),                 //分
                   "s+": this.getSeconds(),                 //秒
                   "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                   "S": this.getMilliseconds()             //毫秒
               };
               if (/(y+)/.test(fmt))
                   fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
               for (var k in o)
                   if (new RegExp("(" + k + ")").test(fmt))
                       fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
               return new Date(fmt);
           }

           var data = (new Date()).Format("yyyy-MM-dd");
           if (new Date(res.data.serviceEndTime) < new Date(data)) {
               alert("请到首页企业充值页面续费后操作");
               window.location.href="dashboard.html";
           }
            isAuthentication=true;
        }else if(res.data.authenticationStatus==3){
            errMsg="认证失败,请重新认证";
            isAuthentication=false;
        }
    });
    $.ajaxSettings.async = true;
    if(isAuthentication){
        $("#enterprise").attr("src","receiveResume.html");
    }else{
        alert(errMsg);
        if(authenticationStatus==0||authenticationStatus==3){
            $("#enterprise").attr("src","authentication.html");
        }
    }
}
function jumpAccountInfo() {
    $("#enterprise").attr("src","accountInfo.html");
}
function jumpEnterpriseInfo() {
    $("#enterprise").attr("src","enterpriseInfo.html");
}

function jumpInterViewNotify() {
    var isAuthentication=false;
    var errMsg="";
    var authenticationStatus=0;
    var data={};
    data.id=JSON.parse(localStorage.getItem("enterprise")).id;
    $.ajaxSettings.async = false;
    $.post("/api/enterprise/detail",data,function(res){
        console.log(res.data);
        authenticationStatus=res.data.authenticationStatus;
        //第一个认证的
        if(res.data.authenticationStatus==0){
            errMsg="请认证";
            isAuthentication=false;
        }else if(res.data.authenticationStatus==1){
            errMsg="请等待认证";
            isAuthentication=false;
        }else if(res.data.authenticationStatus==2){
            //判断是否到期
            Date.prototype.Format = function (fmt) { //author: meizz
                var o = {
                    "M+": this.getMonth() + 1,                 //月份
                    "d+": this.getDate(),                    //日
                    "h+": this.getHours(),                   //小时
                    "m+": this.getMinutes(),                 //分
                    "s+": this.getSeconds(),                 //秒
                    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                    "S": this.getMilliseconds()             //毫秒
                };
                if (/(y+)/.test(fmt))
                    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                for (var k in o)
                    if (new RegExp("(" + k + ")").test(fmt))
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                return new Date(fmt);
            }

            var data = (new Date()).Format("yyyy-MM-dd");
            if (new Date(res.data.serviceEndTime) < new Date(data)) {
                alert("请到首页企业充值页面续费后操作");
                window.location.href="dashboard.html";
            }
            isAuthentication=true;
        }else if(res.data.authenticationStatus==3){
            errMsg="认证失败,请重新认证";
            isAuthentication=false;
        }
    });
    $.ajaxSettings.async = true;
    if(isAuthentication){
        $("#enterprise").attr("src","interviewNotify.html");
    }else{
        alert(errMsg);
        if(authenticationStatus==0||authenticationStatus==3){
            $("#enterprise").attr("src","authentication.html");
        }
    }
}
function jumpIssueJob() {
    $("#enterprise",parent.document).attr("src","issueJob.html");
}


function jumpHome() {
    window.history.back(-1);
}


function jumpFindResume() {
    window.location.href="findResume.html";
}
function jumpRegister(){
    window.location.href="reg.html";
}
function jumpEnterprise() {
    window.location.href="enterprise.html"
}
function goBack() {
    window.history.back(-1);
}

function changeFrameHeight(that){
    //电脑屏幕高度-iframe上面其他组件的高度
    //例:我这里iframe上面还有其他一些div组件，一共的高度是120，则减去120
    $(that).height(document.documentElement.clientHeight - 120);

}