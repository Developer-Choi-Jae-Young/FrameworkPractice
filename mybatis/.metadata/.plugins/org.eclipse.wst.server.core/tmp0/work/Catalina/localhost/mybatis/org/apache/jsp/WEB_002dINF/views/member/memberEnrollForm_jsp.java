/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-04 06:10:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memberEnrollForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1725412795299L));
    _jspx_dependants.put("jar:file:/D:/workspace/mybatis/mybatisProject/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("/WEB-INF/views/common/menubar.jsp", Long.valueOf(1725416615197L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("	.outer {\r\n");
      out.write("		background-color: tomato;\r\n");
      out.write("		color: white;\r\n");
      out.write("		width: 1000px;\r\n");
      out.write("		margin: auto;\r\n");
      out.write("		margin-top: 50px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#enroll-form table {\r\n");
      out.write("		margin: auto;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#enroll-form input {\r\n");
      out.write("		margin: 5px;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery library -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Popper JS -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled JavaScript -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("	.login-area > *{\r\n");
      out.write("		float: right;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.login-area a {\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		color: black;\r\n");
      out.write("		font-size: 12px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.nav-area{\r\n");
      out.write("		background-color: lightblue;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.menu {\r\n");
      out.write("		display: table-cell;\r\n");
      out.write("		width: 150px;\r\n");
      out.write("		height: 50px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.menu a {\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		color: white;\r\n");
      out.write("		font-size: 20px;\r\n");
      out.write("		font-weight: 900;\r\n");
      out.write("		display: inline-block;\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		height: 100%;\r\n");
      out.write("		line-height: 50px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.menu a:hover {\r\n");
      out.write("		background-color: pink;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");

      out.write('\r');
      out.write('\n');
      out.write('	');
 if(alertMsg != null) { 
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		alert(\"");
      out.print( alertMsg );
      out.write("\");\r\n");
      out.write("	</script>		\r\n");
      out.write("	");
 session.removeAttribute("alertMsg"); 
      out.write('\r');
      out.write('\n');
      out.write('	');
 } 
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<h1 align=\"center\">Hello My World!</h1>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"login-area\">	\r\n");
      out.write("		");
      //  c:choose
      org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
      boolean _jspx_th_c_005fchoose_005f0_reused = false;
      try {
        _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fchoose_005f0.setParent(null);
        int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
        if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("			");
            //  c:when
            org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
            boolean _jspx_th_c_005fwhen_005f0_reused = false;
            try {
              _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
              _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
              // /WEB-INF/views/common/menubar.jsp(75,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ empty loginUser }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
              int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
              if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("				<!-- 로그인 전 -->\r\n");
                  out.write("				<form action=\"");
                  out.print( contextPath );
                  out.write("/login.me\" method=\"post\">\r\n");
                  out.write("					<table>\r\n");
                  out.write("						<tr>\r\n");
                  out.write("							<th>아이디</th>\r\n");
                  out.write("							<td>\r\n");
                  out.write("								<input type=\"text\" name=\"userId\" required>\r\n");
                  out.write("							</td>\r\n");
                  out.write("						</tr>\r\n");
                  out.write("						<tr>\r\n");
                  out.write("							<th>비밀번호</th>\r\n");
                  out.write("							<td>\r\n");
                  out.write("								<input type=\"password\" name=\"userPwd\" required>\r\n");
                  out.write("							</td>\r\n");
                  out.write("						</tr>\r\n");
                  out.write("						<tr>\r\n");
                  out.write("							<th colspan=\"2\">\r\n");
                  out.write("								<button type=\"submit\">로그인</button>\r\n");
                  out.write("								<button type=\"button\" onclick=\"enrollPage();\">회원가입</button>\r\n");
                  out.write("							</th>\r\n");
                  out.write("						</tr>\r\n");
                  out.write("					</table>\r\n");
                  out.write("					<script>\r\n");
                  out.write("						// 회원가입 페이지 요청\r\n");
                  out.write("						function enrollPage() {							\r\n");
                  out.write("							// 서블릿을 사용하여 페이지 요청\r\n");
                  out.write("							location.href = \"");
                  out.print( contextPath );
                  out.write("/enrollForm.me\"\r\n");
                  out.write("						}\r\n");
                  out.write("					</script>\r\n");
                  out.write("				</form>\r\n");
                  out.write("			");
                  int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
              _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
              _jspx_th_c_005fwhen_005f0_reused = true;
            } finally {
              org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f0_reused);
            }
            out.write("\r\n");
            out.write("			");
            //  c:otherwise
            org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
            boolean _jspx_th_c_005fotherwise_005f0_reused = false;
            try {
              _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
              _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
              int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
              if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("				<!-- 로그인 후 -->\r\n");
                  out.write("				<div>\r\n");
                  out.write("					<b>");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ loginUser.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
                  out.write("</b>님의 방문을 환영합니다 ^^ <br><br>\r\n");
                  out.write("		\r\n");
                  out.write("					<div align=\"center\">\r\n");
                  out.write("						<a href=\"");
                  out.print( contextPath );
                  out.write("/myPage.me\">마이페이지</a>\r\n");
                  out.write("						<a href=\"");
                  out.print( contextPath );
                  out.write("/logout.me\">로그아웃</a>\r\n");
                  out.write("					</div>\r\n");
                  out.write("				</div>\r\n");
                  out.write("			");
                  int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
              _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
              _jspx_th_c_005fotherwise_005f0_reused = true;
            } finally {
              org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fotherwise_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fotherwise_005f0_reused);
            }
            out.write("\r\n");
            out.write("		");
            int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
        _jspx_th_c_005fchoose_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f0_reused);
      }
      out.write("\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<br clear=\"both\">\r\n");
      out.write("	<br>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"nav-area\" align=\"center\">\r\n");
      out.write("		<div class=\"menu\"><a href=\"");
      out.print( contextPath );
      out.write("\">HOME</a></div>\r\n");
      out.write("		<div class=\"menu\"><a href=\"#\">공지사항</a></div>\r\n");
      out.write("		<div class=\"menu\"><a href=\"#\">일반게시판</a></div>\r\n");
      out.write("		<div class=\"menu\"><a href=\"#\">사진게시판</a></div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("		document.title = \"MyBatis\";\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"outer\">\r\n");
      out.write("		<br>\r\n");
      out.write("		\r\n");
      out.write("		<h2 align=\"center\">회원가입</h2>\r\n");
      out.write("	\r\n");
      out.write("		<form id=\"enroll-form\" action=\"");
      out.print( contextPath );
      out.write("/insert.me\" method=\"post\">\r\n");
      out.write("			<table>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>* 아이디</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"text\" name=\"userId\" maxlength=\"12\" required>\r\n");
      out.write("					</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"button\" value=\"중복체크\" onclick=\"idCheck();\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>* 비밀번호</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"password\" name=\"userPwd\" maxlength=\"15\" required>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>* 비밀번호 확인</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"password\" name=\"userPwdCheck\" maxlength=\"15\" required>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>* 이름</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"text\" name=\"userName\" maxlength=\"6\" required>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>전화번호</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"tel\" name=\"phone\" placeholder=\"- 포함해서 입력\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>이메일</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"email\" name=\"email\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>주민번호 앞자리</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"text\" name=\"birthday\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>성별</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"radio\" name=\"gender\" value=\"M\">남					\r\n");
      out.write("						<input type=\"radio\" name=\"gender\" value=\"F\">여\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>주소</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"text\" name=\"address\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("			\r\n");
      out.write("			<br><br>\r\n");
      out.write("			\r\n");
      out.write("			<div align=\"center\">\r\n");
      out.write("				<button type=\"submit\" onclick=\"return pwdCheck();\" disabled>회원가입</button>\r\n");
      out.write("				<button type=\"reset\">초기화</button>\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<br><br>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		function pwdCheck() {\r\n");
      out.write("			const pwd = document.querySelector(\"#enroll-form input[name=userPwd]\").value;\r\n");
      out.write("			const pwdCheck = document.querySelector(\"#enroll-form input[name=userPwdCheck]\").value;\r\n");
      out.write("\r\n");
      out.write("			if(pwd != pwdCheck) {\r\n");
      out.write("				alert(\"비밀번호와 비밀번호 확인 입력값이 다릅니다.\");\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		function idCheck() {\r\n");
      out.write("			// 중복체크 버튼 클릭 시 사용자가 입력한 아이디 값을 서버로 보내서\r\n");
      out.write("			// 중복되는 데이터가 있는 지 조회한 후에 결과를 받을 것임\r\n");
      out.write("			\r\n");
      out.write("			// (1) 사용 가능 => 사용 가능합니다. 메시지 출력, 회원가입 버튼을 활성화\r\n");
      out.write("			// (2) 사용 불가능 => 사용할 수 없는 아이디 입니다. 메시지 출력, 다시 입력할 수 있도록 유도\r\n");
      out.write("			const userId = $(\"#enroll-form input[name=userId]\").val();\r\n");
      out.write("			\r\n");
      out.write("			console.log(\"userId: \" + userId);\r\n");
      out.write("			\r\n");
      out.write("			console.log(\"*** ajax 요청 전 ***\");\r\n");
      out.write("			\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url: 'idCheck.me',\r\n");
      out.write("				type: 'get',\r\n");
      out.write("				data: {\r\n");
      out.write("					userId: userId\r\n");
      out.write("				},\r\n");
      out.write("				success: function(result) {\r\n");
      out.write("					// result ===> 중복된 아이디가 있을 경우 (\"NNN\"), 없을 경우 (\"NNY\")\r\n");
      out.write("					console.log(result);\r\n");
      out.write("					\r\n");
      out.write("					if(result == \"NNN\") {\r\n");
      out.write("						alert(\"사용할 수 없는 아이디 입니다.\");\r\n");
      out.write("						$(\"#enroll-form button[type=submit]\").attr(\"disabled\", true);\r\n");
      out.write("						$(\"input[name=userId]\").focus();\r\n");
      out.write("					} else if(result == \"NNY\") {\r\n");
      out.write("						alert(\"사용 가능합니다.\");\r\n");
      out.write("						$(\"#enroll-form button[type=submit]\").attr(\"disabled\", false);\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				error: function(err) {\r\n");
      out.write("					console.log(err);\r\n");
      out.write("				},\r\n");
      out.write("				complete: function() {\r\n");
      out.write("					\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
