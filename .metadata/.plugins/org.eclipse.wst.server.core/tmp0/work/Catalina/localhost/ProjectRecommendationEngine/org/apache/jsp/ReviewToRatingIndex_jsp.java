/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.35
 * Generated at: 2016-06-07 19:38:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ReviewToRatingIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

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
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
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

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Review To Rating Mapper</title>\n");
      out.write("<style>\n");
      out.write("\t\t\tdiv.heading {\n");
      out.write("\t\t\t\tbackground-color:orange;\n");
      out.write("\t\t\t\tcolor:white;\n");
      out.write("\t\t\t\tmargin:20px;\n");
      out.write("\t\t\t\tpadding:20px;\n");
      out.write("\t\t\t\tfont-size: 20;\n");
      out.write("\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\th1 {\n");
      out.write("\t\t\t\ttext-align: center\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tdiv.even{\n");
      out.write("\t\t\t\tbackground-color:white;\n");
      out.write("\t\t\t\tcolor:orange;\n");
      out.write("\t\t\t\tmargin:20px;\n");
      out.write("\t\t\t\tpadding:20px;\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tdiv.odd{\n");
      out.write("\t\t\t\tbackground-color:orange;\n");
      out.write("\t\t\t\tcolor:white;\n");
      out.write("\t\t\t\tmargin:20px;\n");
      out.write("\t\t\t\tpadding:20px;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tform{\n");
      out.write("\t\t\tpadding:20px;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tinput{\n");
      out.write("\t\t\t\tmargin-top:20px;\n");
      out.write("\t\t\t\tbackground-color:orange;\n");
      out.write("\t\t\t\ttext-align:center;\n");
      out.write("\t\t\t\tcolor:white;\n");
      out.write("\t\t\t\twidth:100px;\n");
      out.write("\t\t\t\theight: 40px;\n");
      out.write("\t\t\t\tfont-weight:bolder;\n");
      out.write("\t\t\t\tfont-size:large;\n");
      out.write("\t\t\t\tmargin-left:550px;\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tinput.txtbx{\n");
      out.write("\t\t\t\tmargin-left:49px;\n");
      out.write("\t\t\t\tbackground-color:orange;\n");
      out.write("\t\t\t\ttext-align:center;\n");
      out.write("\t\t\t\tcolor:white;\n");
      out.write("\t\t\t\twidth:1100px;\n");
      out.write("\t\t\t\theight: 50px;\n");
      out.write("\t\t\t\tfont-weight:bolder;\n");
      out.write("\t\t\t\tfont-size:large;\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\th2 {\n");
      out.write("\t\t\t\ttext-align: center;\n");
      out.write("\t\t\t\tcolor:orange;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"heading\">\n");
      out.write("\t\t\t<h1>Personalized Movie Recommendation System</h1>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<h2>Review To Rating Mapper</h2><hr />\n");
      out.write("<form name=\"userform\" method=\"post\" action=\"submitReviewText\">\n");
      out.write("<h3>Write your review and convert it to corresponding rating</h3><br>\n");
      out.write("<label>Write Your Review Here</label>\n");
      out.write("<input class = \"txtbx\" type=\"text\" id=\"reviewText\" name=\"reviewText\"><br>\n");
      out.write("<input type=\"submit\" name=\"Submit\" value=\"Submit\" tabindex=\"2\" />\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
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
