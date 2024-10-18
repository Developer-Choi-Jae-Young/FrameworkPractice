$(function () {
	$('#btn1').click(function () {
		getAirPollution('air.do', 1, function (data) {
			appendJsonData("", data);
		});
	});

	$('#btn2').click(function () {
		getAirPollution('air2.do', 1, function (data) {
			appendXmlData("", data);
		})
	});
	
	$('#location').change(function() {
		$('tbody').html("");
		$('table + button').remove();
	});
});

const getAirPollution = (url, pageNo, callback) => {
	$.ajax({
		url: url,
		method: 'get',
		data: {
			location: $('#location').val(),
			pageNo: pageNo
		},
		success: function (data) {
			callback(data);
		},
		error: function (err) {
			console.log(err);
		}
	});
}

const getMoreData = (url, nextNo, type) => {
	getAirPollution(url, nextNo, function (data) {

		if(type == "json") {
			appendJsonData($('tbody').html(), data);
		} else {
			appendXmlData($('tbody').html(), data);
		}
	});
}

const appendJsonData = (tableData, data) => {
	let strData = tableData;

	for (let item of data.response.body.items) {
		strData += "<tr class='table-dark'>"
			+ "<td>" + item.stationName + "</td>"
			+ "<td>" + item.dataTime + "</td>"
			+ "<td>" + item.khaiValue + "</td>"
			+ "<td>" + item.pm10Value + "</td>"
			+ "<td>" + item.coValue + "</td>"
			+ "<td>" + item.no2Value + "</td>"
			+ "<td>" + item.so2Value + "</td>"
			+ "<td>" + item.o3Value + "</td>"
			+ "</tr>"
	}

	$('tbody').html(strData);

	$('table + button').remove();
	
	if( $('tbody tr').length < data.response.body.totalCount ) {
		$('table').after("<button class='btn btn-dark w-100' onclick='getMoreData(\"air.do\", " + (data.response.body.pageNo + 1) + ", \"json\")'>더 보기</button>");
	}
}

const appendXmlData = (tableData, data) => {
	const itemArr = $(data).find("item");
	let strData = tableData;

	itemArr.each((index, item) => {
		strData += "<tr class='table-dark'>"
			+ "<td>" + $(item).find("stationName").text() + "</td>"
			+ "<td>" + $(item).find("dataTime").text() + "</td>"
			+ "<td>" + $(item).find("khaiValue").text() + "</td>"
			+ "<td>" + $(item).find("pm10Value").text() + "</td>"
			+ "<td>" + $(item).find("coValue").text() + "</td>"
			+ "<td>" + $(item).find("no2Value").text() + "</td>"
			+ "<td>" + $(item).find("so2Value").text() + "</td>"
			+ "<td>" + $(item).find("o3Value").text() + "</td>"
			+ "</tr>"

	})

	$('tbody').html(strData);

	$('table + button').remove();

	if( $('tbody tr').length < $(data).find("totalCount").text() ) {
		$('table').after("<button class='btn btn-dark w-100' onclick='getMoreData(\"air2.do\", " + (parseInt($(data).find("pageNo").text()) + 1) + ", \"xml\")'>더 보기</button>");
	}
}