<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/styles.css">
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
						Đăng kí tín chỉ
					</h3>
				</div>
			</div>

			<div class="signup__body">
                <table>
                   <tbody>
                      <tr>
                         <td>
                            <div id="ctl00_ContentPlaceHolder1_ctl00_pnlLocMonHoc">
                               <table cellpadding="0" cellspacing="0">
                                  <tbody>
                                     <tr>
                                        <td style="width: 110px">
                                           <span id="ctl00_ContentPlaceHolder1_ctl00_lblLocMH" style="display:inline-block;width:110px;">Lọc theo môn học: </span>
                                        </td>
                                        <td>
                                           <input type="text" id="txtMaMH1">
                                           <a id="searchSubject" href="javascript:void(0)" onclick="subject.findByCode()">Tìm kiếm</a></li>
                                        </td>
                                     </tr>
                                  </tbody>
                               </table>
                            </div>
                         </td>
                      </tr>
                   </tbody>
                </table>
			</div>
		</div>

		<table id="pnlDSMonhocDK" style="visibility: hidden">
            <tbody>
               <tr>
                  <td align="center">
                     <div align="left">
                        <table cellspacing="0" cellpadding="0" class="title-table">
                           <tbody>
                              <tr align="center" height="30px">
                                 <td width="25px">
                                    <asp:label id="lblG1DK" runat="server">  </asp:label>
                                 </td>
                                 <td width="60px">
                                    <asp:label id="lblG1MMH" runat="server">Mã MH</asp:label>
                                 </td>
                                 <td width="150x">
                                    <asp:label id="lblG1TMH" runat="server">Tên môn học </asp:label>
                                 </td>
                                 <td width="35px">
                                    <asp:label id="lblG1NMM" runat="server">NMH</asp:label>
                                 </td>
                                 <td width="30px">
                                    <asp:label id="lblG1TTH" runat="server">TTH</asp:label>
                                 </td>
                                 <td width="25px">
                                    <asp:label id="lblG1STC" runat="server">STC</asp:label>
                                 </td>
                                 <td width="35px">
                                    <asp:label id="lblG1STCHP" runat="server">STCHP</asp:label>
                                 </td>
                                 <td width="77px">
                                    <asp:label id="lblG1MaLop" runat="server">Mã lớp</asp:label>
                                 </td>
                                 <td width="28px">
                                    <asp:label id="lblG1SCP" runat="server">Sĩ số</asp:label>
                                 </td>
                                 <td width="28px">
                                    <asp:label id="lblG1CL" runat="server">CL</asp:label>
                                 </td>
                                 <td width="20px">
                                    <asp:label id="lblG1TH" runat="server">TH</asp:label>
                                 </td>
                                 <td width="35px">
                                    <asp:label id="lblG1Thu" runat="server">Thứ </asp:label>
                                 </td>
                                 <td width="40px">
                                    <asp:label id="lblG1TBD" runat="server">Tiết BD</asp:label>
                                 </td>
                                 <td width="30px">
                                    <asp:label id="lblG1ST" runat="server">ST</asp:label>
                                 </td>
                                 <td width="60px">
                                    <asp:label id="lblG1Phong" runat="server">Phòng</asp:label>
                                 </td>
                                 <td width="70px">
                                    <asp:label id="lblG1TenGV" runat="server">Giảng viên</asp:label>
                                 </td>
                                 <td>
                                    <asp:label id="lblG1Tuan" runat="server">Tuần</asp:label>
                                 </td>
                              </tr>
                           </tbody>
                        </table>
                     </div>
                     <div style="height: 320px" class="grid-roll">
                        <div id="divTDK">
                           <table class="body-table" style="border-collapse: collapse;" rules="all" border="1" cellspacing="0" cellpadding="0">
                              <tbody id="lichHocTBL">
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </td>
               </tr>
            </tbody>
         </table>

		<div style="display: flex; justify-content: center;">
			<button class="btn" type="submit"> Chọn </button>
		</div>

	</form>

	<font color="red">${errorMessage}</font>
</div>
</body>
<script src="js/ajax.js"></script>

</html>