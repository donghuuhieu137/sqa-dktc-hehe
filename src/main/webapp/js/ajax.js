var subject = {
    findByCode: function() {
        data = $("#txtMaMH1").val();
        console.log(data)

        $.ajax({
            url: "/subjects",
            type: "post",
            data: data, // object json -> string json
            dataType: "text", // dữ liệu từ web-service trả về là json.
            success: function(textResult) { // được gọi khi web-service trả về dữ liệu.
                var jsonResult = jQuery.parseJSON(textResult);
                console.log(jsonResult.data.length);
//                if (!jsonResult.data.length){
//                    $("#pnlDSMonhocDK").css("visibility", "hidden");
//                }
                if (jsonResult.status == 200) {
                    for (let i = 0; i < jsonResult.data.length; i++) {
                        console.log(jsonResult.data[i]);
                        var html = '<tr>';
                        html += "<td width=\"25px\" align=\"center\"><input type=\"radio\" name=\"chon_mon_hoc\" class=\"chon_mon_hoc\" id=\"chk_" + jsonResult.data[i].maMon + "\" value=\"" + jsonResult.data[i].id + "\"></td>    <td width=\"60px\" align=\"center\">" + jsonResult.data[i].maMon + "</td>    <td width=\"150x\" align=\"left\">&nbsp;" + jsonResult.data[i].ten + "</td>    <td width=\"35px\" align=\"center\">" + jsonResult.data[i].nhom + "</td>    <td width=\"30px\" align=\"center\"></td>    <td width=\"25px\" align=\"center\">" + jsonResult.data[i].soTinChi + "</td>    <td width=\"35px\" align=\"center\">" + jsonResult.data[i].soTinChiHP + "</td>    <td width=\"77px\" align=\"center\">" + jsonResult.data[i].maLop + "</td>    <td width=\"28px\" align=\"center\">" + jsonResult.data[i].siSo + "</td>    <td width=\"28px\" align=\"center\">" + jsonResult.data[i].conLai + "</td>";
                        // thoi gian

                        // to thuc hanh
                        html += "<td width=\"20px\" align=\"center\">";
                        for (let j = 0; j < jsonResult.data[i].timeTable.length; j++) {
                            if (j != 0) {
                                html += "<div class=\"fline\">&nbsp;</div>";
                            }
                            html += "<div class=\"top-fline\"></div>";

                        }
                        html += "</td>";

                        // thu
                        html += "<td width=\"35px\" align=\"center\">";
                        for (let j = 0; j < jsonResult.data[i].timeTable.length; j++) {
                            if (j != 0) {
                                html += "<div class=\"fline\">&nbsp;</div>";
                            }
                            html += "<div class=\"top-fline\">" + jsonResult.data[i].timeTable[j].thu + "</div>";

                        }
                        html += "</td>";

                        // tiet bat dau
                        html += "<td width=\"40px\" align=\"center\">";
                        for (let j = 0; j < jsonResult.data[i].timeTable.length; j++) {
                            if (j != 0) {
                                html += "<div class=\"fline\">&nbsp;</div>";
                            }
                            html += "<div class=\"top-fline\">" + jsonResult.data[i].timeTable[j].tietBatDau + "</div>";

                        }
                        html += "</td>";

                        // so tiet
                        html += "<td width=\"30px\" align=\"center\">";
                        for (let j = 0; j < jsonResult.data[i].timeTable.length; j++) {
                            if (j != 0) {
                                html += "<div class=\"fline\">&nbsp;</div>";
                            }
                            html += "<div class=\"top-fline\">" + jsonResult.data[i].timeTable[j].soTiet + "</div>";

                        }
                        html += "</td>";

                        // tiet phong
                        html += "<td width=\"60px\" align=\"center\">";
                        for (let j = 0; j < jsonResult.data[i].timeTable.length; j++) {
                            if (j != 0) {
                                html += "<div class=\"fline\">&nbsp;</div>";
                            }
                            html += "<div class=\"top-fline\">" + jsonResult.data[i].timeTable[j].phong + "</div>";

                        }
                        html += "</td>";

                        // giang vien
                        html += "<td width=\"70px\" align=\"center\">";
                        for (let j = 0; j < jsonResult.data[i].timeTable.length; j++) {
                            if (j != 0) {
                                html += "<div class=\"fline\">&nbsp;</div>";
                            }
                            html += "<div class=\"top-fline\">" + jsonResult.data[i].timeTable[j].giangVien + "</div>";

                        }
                        html += "</td>";

                        // tuan
                        html += "<td style=\"font-size: 12px; font-family: Courier\" align=\"left\">";
                        for (let j = 0; j < jsonResult.data[i].timeTable.length; j++) {
                            if (j != 0) {
                                html += "<div class=\"fline\">&nbsp;</div>";
                            }
                            html += "<div class=\"top-fline\"><label style=\"cursor:pointer\">" + jsonResult.data[i].timeTable[j].tuan + "</label></div>";

                        }
                        html += "</td>";
                        html += "</tr>";
                        $("#lichHocTBL").append(html);
                    }

                    // location.reload();
                    $("#pnlDSMonhocDK").css("visibility", "visible");
                } else {
                    alert("eror");
                }
            },
            error: function(jqXhr, textStatus, errorMessage) { // error callback

            }
        });
    },

    save: function() {
        data = $(".chon_mon_hoc:checked").val();
        console.log(data)
        $.ajax({
            url: "/save-subject",
            type: "post",
            data: data, // object json -> string json
            dataType: "text", // dữ liệu từ web-service trả về là json.
            success: function(textResult) { // được gọi khi web-service trả về dữ liệu.
                var jsonResult = jQuery.parseJSON(textResult);
                alert(jsonResult.data);
            },
            error: function(jqXhr, textStatus, errorMessage) { // error callback

            }
        });
    },

    remove: function() {
        data = $(".xoa_mon_hoc:checked").val();
        eleId = "#tr_chk_"+data;
        console.log(eleId);
        element = $(eleId);
        console.log(data)
        $.ajax({
            url: "/remove-subject",
            type: "post",
            data: data, // object json -> string json
            dataType: "text", // dữ liệu từ web-service trả về là json.
            success: function(textResult) { // được gọi khi web-service trả về dữ liệu.
                var jsonResult = jQuery.parseJSON(textResult);
                element.remove();
                alert(jsonResult.data);
            },
            error: function(jqXhr, textStatus, errorMessage) { // error callback

            }
        });
    },
};