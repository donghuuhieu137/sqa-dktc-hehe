<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="css/styles.css">
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
      <title>Document</title>
      <script src="https://code.jquery.com/jquery-1.10.2.js"type="text/javascript"></script>
      <script src="js/ajax.js" type="text/javascript"></script>
   </head>
   <body>
      <div class="container">
      <form action="" method="post">
         <div class="signup">
            <div class="signup__head">
               <div>
                  <h3 class="signup__title">
                     Học phần đã đăng ký
                  </h3>
               </div>
            </div>
            <div class="signup__body">
               <div id="ctl00_ContentPlaceHolder1_ctl00_pnlDaChon">
                  <div style="margin-top: 5px;" id="titleDSDK">
                     <span id="ctl00_ContentPlaceHolder1_ctl00_lblDaChon" class="Label" style="font-size:14px;font-weight:bold;">XEM ĐĂNG KÝ</span>
                     <table cellspacing="0" cellpadding="0" class="title-table">
                        <tbody>
                           <tr>
                              <td colspan="11" align="right" style="background-color:#6699FF;height:5px;"></td>
                              <td align="center" style="background-color:#6699FF;height:5px;">
                                 <input type="button" id="bntXoaChon" value="Xóa" onclick=subject.remove()>
                              </td>
                           </tr>
                           <tr align="center">
                              <td style="width: 30px;">
                                 <asp:label id="lblG2STT" runat="server">STT</asp:label>
                              </td>
                              <td style="display:none">
                                 <asp:label id="lblG2MaDK" runat="server">Regis ID </asp:label>
                              </td>
                              <td style="width: 60px;">
                                 <asp:label id="lblG2MMH" runat="server">Mã MH </asp:label>
                              </td>
                              <td style="width: 180px;">
                                 <asp:label id="lblG2TMH" runat="server">Tên môn học </asp:label>
                              </td>
                              <td style="width: 35px;">
                                 <asp:label id="lblG2NMH" runat="server">NMH </asp:label>
                              </td>
                              <td style="width: 45px;">
                                 <asp:label id="lblG2TTH" runat="server">TTH </asp:label>
                              </td>
                              <td style="width: 35px;">
                                 <asp:label id="lblG2STC" runat="server">STC </asp:label>
                              </td>
                              <td style="width: 35px;">
                                 <asp:label id="lblG2STCHP" runat="server">STCHP </asp:label>
                              </td>
                              <td style="width: 80px;">
                                 <asp:label id="lblG2HP" runat="server">Học Phí</asp:label>
                              </td>
                              <td style="width: 80px;">
                                 <asp:label id="lblG2MG" runat="server">Miễn Giảm</asp:label>
                              </td>
                              <td style="width: 80px;">
                                 <asp:label id="lblG2PD" runat="server">Phải Đóng</asp:label>
                              </td>
                              <td>
                                 <asp:label id="lblG2TrangThai" runat="server">Trạng Thái môn học </asp:label>
                              </td>
                            </tr>
                        </tbody>
                     </table>
                  </div>
                  <div id="divTemp" class="grid-roll" style="height: 240px">
                     <div id="divKQ">
                        <table class="body-table" style="border-collapse: collapse; color:Navy;" rules="all" border="1" cellspacing="0" cellpadding="0">
                           <tbody>
                              <c:forEach items="${subjects}" var="subject">
                                  <tr id="tr_chk_${subject.id}">
                                    <td style="width: 30px;" valign="middle" align="center">1</td>
                                    <td style="width: 60px;" valign="middle" align="center">${subject.maMon}</td>
                                    <td style="width: 180px;" valign="middle" align="left">&nbsp;${subject.ten}</td>
                                    <td style="width: 35px;" valign="middle" align="center">${subject.nhom}</td>
                                    <td style="width: 45px;" valign="middle" align="center">${subject.toThucHanh}</td>
                                    <td style="width: 35px;" valign="middle" align="center">${subject.soTinChi}</td>
                                    <td style="width: 35px;" valign="middle" align="center">${subject.soTinChiHP}</td>
                                    <td style="width: 80px;" valign="middle" align="right">${subject.tongHocPhi}&nbsp;</td>
                                    <td style="width: 80px;" valign="middle" align="right">&nbsp;</td>
                                    <td style="width: 80px;" valign="middle" align="right">${subject.tongHocPhi}&nbsp;</td>
                                    <td valign="middle" align="left">&nbsp;Đã lưu vào CSDL</td>
                                    <td valign="middle" align="left" style="width: 50px;"><input style="" type="radio" name="xoa_mon_hoc" class="xoa_mon_hoc" id="chk_${subject.id}" name="subjects[]" value="${subject.id}"></td>
                                  </tr>
                              </c:forEach>
                              <tr style="font-weight: bold;" height="20px">
                                 <td valign="middle" align="center" colspan="5">Tổng cộng</td>
                                 <td valign="middle" align="center">${tongSoTinChi}</td>
                                 <td valign="middle" align="center">${tongSoTinChi}</td>
                                 <td valign="middle" align="right">${tongHocPhi}&nbsp;</td>
                                 <td valign="middle" align="right">00&nbsp;</td>
                                 <td valign="middle" align="right">${tongHocPhi}&nbsp;</td>
                                 <td valign="middle" align="left"></td>
                                 <td valign="middle" align="center">
                                 </td>
                              </tr>
                           </tbody>
                        </table>
                     </div>
                  </div>
               </div>
            </div>
            <div style="display: flex; justify-content: center;">
               <a href="/homepage"> Quay lại </a>
            </div>
      </form>
      <font color="red">${errorMessage}</font>
      </div>
   </body>
   <script src="js/ajax.js"></script>
</html>