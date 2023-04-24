var subject = {
		findByCode: function() {
//			var data = {};
//			data["ma_mon"] = $("#txtMaMH1").val();
//			console.log(data["ma_mon"])
			data = $("#txtMaMH1").val();
			console.log(data)

			$.ajax({
				url: "/subjects",
				type: "post",
//				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: data, // object json -> string json
				dataType: "text", // dữ liệu từ web-service trả về là json.
				success: function(textResult) { // được gọi khi web-service trả về dữ liệu.
				    var jsonResult = jQuery.parseJSON(textResult);
					if(jsonResult.status == 200) {
					    console.log(jsonResult.data)
					    console.log(jsonResult.data[0])
					    console.log(jsonResult.data[0].nhom)
					    for (let i = 0; i< jsonResult.data.length; i++) {
                          console.log(jsonResult.data[i]);
                          $("#lichHocTBL").append("<tr>    <td width=\"25px\" align=\"center\"><input type=\"checkbox\" id=\"chk_INT142708\" value=\"INT142708    |INT1427|Kiến trúc và thiết kế phần mềm|08|3|3|01/01/0001|0|0|0| |0|D19CNPM\" disabled=\"\" onclick=\"toDKSelectedChange(this)\"></td>    <td width=\"60px\" align=\"center\">INT1427</td>    <td width=\"150x\" align=\"left\">&nbsp;" + jsonResult.data[i].ten + "</td>    <td width=\"35px\" align=\"center\">08</td>    <td width=\"30px\" align=\"center\"></td>    <td width=\"25px\" align=\"center\">3</td>    <td width=\"35px\" align=\"center\">3</td>    <td width=\"77px\" align=\"center\">D19-070</td>    <td width=\"28px\" align=\"center\">1</td>    <td width=\"28px\" align=\"center\">Hết</td>    <td width=\"20px\" align=\"center\">       <div class=\"top-fline\"></div>       <div class=\"fline\">&nbsp;</div>       <div class=\"top-fline\"></div>    </td>    <td width=\"35px\" align=\"center\">       <div class=\"top-fline\">Sáu</div>       <div class=\"fline\">&nbsp;</div>       <div class=\"top-fline\">Sáu</div>    </td>    <td width=\"40px\" align=\"center\">       <div class=\"top-fline\">11</div>       <div class=\"fline\">&nbsp;</div>       <div class=\"top-fline\">9</div>    </td>    <td width=\"30px\" align=\"center\">       <div class=\"top-fline\">2</div>       <div class=\"fline\">&nbsp;</div>       <div class=\"top-fline\">2</div>    </td>    <td width=\"60px\" align=\"center\">       <div class=\"top-fline\">605-A2</div>       <div class=\"fline\">&nbsp;</div>       <div class=\"top-fline\">605-A2</div>    </td>    <td width=\"70px\" align=\"center\">       <div class=\"top-fline\">N.M.Hùng</div>       <div class=\"fline\">&nbsp;</div>       <div class=\"top-fline\">N.M.Hùng</div>    </td>    <td style=\"font-size: 12px; font-family: Courier\" align=\"left\">       <div class=\"top-fline\"><label id=\"27/03/2023--14/05/2023\" style=\"cursor:pointer\">--------9012345</label></div>       <div class=\"fline\">&nbsp;</div>       <div class=\"top-fline\"><label id=\"30/01/2023--14/05/2023\" style=\"cursor:pointer\">123456789012345</label></div>    </td> </tr>");
                        }
                        // location.reload();
                        $("#pnlDSMonhocDK").css("visibility", "visible");
					} else {
						alert("eror");
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback

			    }
			});
		},
};