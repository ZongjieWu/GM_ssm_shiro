function jumpSelfAuthentication() {
    $("#user").attr("src","authentication.html");
}
function jumpGathering() {
    window.location.href="enterprise/dashboard.html";
}
function jumpUserInfo() {
    $("#user").attr("src","userInfo.html");
}

function jumpUpdateResume(){
    $("#user").attr("src","resume.html");
}
function jumpUserResumePreview() {
    $("#user").attr("src","previewResume.html");
}
function jumpJobList() {
    window.location.href="findJob.html";
}
function jumpUserCenter() {
    window.location.href="user.html";
}

function jumpDetail(data) {
    window.location.href="jobDetail.html?id="+data.id;
}

function jumpHome() {
    document.addEventListener('WeixinJSBridgeReady', function(){ WeixinJSBridge.call('closeWindow'); }, false)
    WeixinJSBridge.call('closeWindow');
}
function jumpFindUserResume() {
    window.location.href="enterprise/findResume.html";
}
function jumpUser() {
    window.location.href="user.html";
}

function jumpSendRecord() {
    $("#user").attr("src","sendRecord.html");
}
function jumpUpdatePwd() {
    $("#user").attr("src","forgetPassword.html");
}
function jumpLogin() {
    window.location.href="login.html";
}

function jumpLogout() {
    localStorage.removeItem("user");
    window.location.href="login.html";
}
function jumpInterViewNotify() {
    $("#user").attr("src","interviewNotify.html");
}
function jumpHome() {
    window.history.back(-1);
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