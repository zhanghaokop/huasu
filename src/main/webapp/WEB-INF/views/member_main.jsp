<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>会员</title>
    <link href="../styles/weui.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="../styles/iconfont/iconfont.css">
        <link rel="stylesheet" href="../styles/responsive.css">
    	<link rel="stylesheet" href="../styles/member_mainInfo.css">
        <link rel="stylesheet" href="../styles/member_index.css">
  </head>
   <style>
          .weui-media-box_appmsg .weui-media-box__bd {
              margin-left: 0.375rem;
          }
          .weui-media-box__desc {
              margin-top: 0.5rem;
          }
          .weui-media-box__title {
              letter-spacing: 0.0625rem;
          }
          .weui-media-box_appmsg .weui-media-box__hd {
              width: 4.75rem;
              height: 4.75rem;
              line-height: 4.75rem;
          }
          .weui-media-box__hd img {
              width: 4.75rem;
              border-radius: 0.25rem;
          }
          .weui-media-box__title,.weui-media-box__desc {
          	color: #fff;
          }
          .iconfont {
          	text-align: center;
          }
          .weui-cell__hd {
  		    margin-right: 1rem;
  		}
  		.weui-cells {
  			background: #F1F1F1;
  		}
          .weui-grid__icon {
              color: #38AF13;
              font-size: 1.375rem;
          }
          .iconfont {
              font-size: 1.375rem;
          }
      </style>
  <body>
   <div class="weui-panel__bd" style="background: #38AF13;margin-bottom: 20px">
          <div class="weui-media-box weui-media-box_appmsg">
              <div class="weui-media-box__hd">
                  <c:choose>
                      <c:when test="${!empty Member.album}">
                          <img src="../img/member/${Member.album}" class="click3">
                       </c:when>
                        <c:otherwise>
                            <img src="../img/default_member2.jpg" class="click3">
                         </c:otherwise>
                   </c:choose>
              </div>
              <div class="weui-media-box__bd">
                  <h4 class="weui-media-box__title">${Member.name}</h4>
                  <p class="weui-media-box__desc">积分：${Member.score}</p>
              </div>
          </div>
      </div>
      <div class="weui-cells" style="margin-top:20px">
          <a class="weui-cell weui-cell_access" href="/wxgzh/memberInfo">
              <div class="weui-cell__hd"><i class="iconfont icon-member2" style="color:#38AF13"></i></div>
              <div class="weui-cell__bd">
                  <p>个人信息</p>
              </div>
              <div class="weui-cell__ft"></div>
          </a>
          <a class="weui-cell weui-cell_access" href="/wxgzh/memberMessage">
              <div class="weui-cell__hd" style="margin-top: -4px;">
                  <i class="iconfont icon-i-w-message" style="color:#38AF13;position: relative;top: 0.125rem;"></i>
              </div>
              <div class="weui-cell__bd">
                  <p>我的消息</p>
              </div>
              <div class="weui-cell__ft">
                  <c:if test="${messageCount!=0}">
                      <span class="weui-badge" style="margin-left: 5px;margin-top: -3px;">${messageCount}</span>
                  </c:if>
                  <%--<% if(count.count!=0){ %>--%>
                      <%--<span class="weui-badge" style="margin-left: 5px;margin-top: -3px;"><%= count.count %></span>--%>
                  <%--<% }%>--%>
              </div>
          </a>
      </div>
  	<div class="weui-grids" style="margin-top:40px;">
          <a href="/wxgzh/repair" class="weui-grid">
              <div class="weui-grid__icon iconfont icon-repair"></div>
              <p class="weui-grid__label">报修服务</p>
          </a>
          <a href="/wxgzh/knowledgeList" class="weui-grid">
              <div class="weui-grid__icon iconfont icon-knowledge"></div>
              <p class="weui-grid__label">常见问题</p>
          </a>
          <a href="/wxgzh/repairHistory" class="weui-grid">
              <div class="weui-grid__icon iconfont icon-tubiao03"></div>
              <p class="weui-grid__label">我的维修</p>
          </a>
          <a href="javascript:;" class="weui-grid" onclick="market();">
              <div class="weui-grid__icon iconfont icon-market2"></div>
              <p class="weui-grid__label">积分商城</p>
          </a>
      </div>
  	<!-- <div class="weui-footer">
  		<p class="weui-footer__text">
  			<a href="tel:13738073681">
  				合作热线:13738073681
  			</a>
  		</p>
  	</div> -->
  <div class="weui-footer weui-footer_fixed-bottom">
      <p class="weui-footer__links">
          <a href="tel:13738073681" class="weui-footer__link">合作热线:13738073681</a>
      </p>
  </div>
  </body>
  <script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="../js/common.js" type="text/javascript"></script>
  <script>
      function sign(){
          wxToast('暂未开放');
      }
      function market(){
          wxToast('暂未开放');
      }
      var needRefresh = sessionStorage.getItem("need-refresh");
      if(needRefresh){
          sessionStorage.removeItem("need-refresh");
          location.reload();
      }
  </script>
</html>
