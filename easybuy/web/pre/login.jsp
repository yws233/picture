<%--
  Created by IntelliJ IDEA.
  User: yws
  Date: 18-1-1
  Time: 上午10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>登录</title>
    <%@ include file="/common/pre/header.jsp" %>
</head>
<body>
<!--Begin Login Begin-->
<div class="log_bg">
    <div class="top">
        <div class="logo"><a href="${ctx}/Home?action=index"><img src="${ctx}/statics/images/logo.png" /></a></div>
    </div>
    <div class="login">
        <div class="log_img"><img src="${ctx}/statics/images/l_img.png" width="611" height="425" /></div>
        <div class="log_c">
            <form>
                <table border="0" style="width:370px; font-size:14px; margin-top:30px;" cellspacing="0" cellpadding="0">
                    <tr height="50" valign="top">
                        <td width="55">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">登录</span>
                            <span class="fr">还没有商城账号，<a href="${ctx}/Register?action=toRegister" style="color:#ff4e00;">立即注册</a></span>
                        </td>
                    </tr>
                    <tr height="70">
                        <td>用户名</td>
                        <td><input type="text" name="loginName" id="loginName" value="" class="l_user" /></td>
                    </tr>
                    <tr height="70">
                        <td>密&nbsp; &nbsp; 码</td>
                        <td><input type="password" name="password" id="password" value="" class="l_pwd" /></td>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td><input type="submit" value="登录" class="log_btn" onclick="login();" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End-->
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2018  <br />
        <img src="${ctx}/statics/images/b_1.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_2.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_3.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_4.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_5.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_6.gif" width="98" height="33" />
    </div>
</div>
<!--End Footer End -->
</body>
</html>
