$(function() {
	$('#btn1').click(function() {
		getTsunamiShelter(1);
	});
	
	$('#rows').change(function() {
		$('tbody').html("");
		$('#page-area li').remove();
	});
});

const getTsunamiShelter = (pageNo) => {
	$.ajax({
			url: "shelter.do",
			method: "get",
			data: { 
				pageNo: pageNo,
				numOfRows: $('#rows').val()
			},
			success: function(result) {
				let maxNum = result.TsunamiShelter[0].head[0].totalCount
				$('#maxPage').text(Math.ceil((maxNum / $('#rows').val())));
				$('#currPage').text(pageNo);
				let rows = result.TsunamiShelter[0].head[1].numOfRows;
				
				let dataArr = result.TsunamiShelter[1].row;
				let tableData = "";
				
				for(let i in dataArr) {
					const item = dataArr[i];
					tableData += "<tr>"
					+ "<td>" + item.shel_nm + "</td>"
					+ "<td>" + item.address + "</td>"
					+ "<td>" + item.shel_av + "</td>"
					+ "<td>" + item.shel_div_type + "</td>"
					+ "<td>" + item.tel + "</td>"
					+ "<td>" + item.manage_gov_nm + "</td>"
					+ "</tr>";
				}
				
				$('tbody').html(tableData);
				
				showPagination(pageNo, Math.ceil((maxNum / $('#rows').val())));
			},
			error: function(err) {
				console.log(err);
			}
		});
}

const showPagination = (currPage, maxPage) => {
	const pageLimit = 10;
	let startPage;
	let endPage;
	startPage = Math.floor((currPage - 1) / pageLimit) * pageLimit + 1;
	endPage = startPage + pageLimit - 1;
	
	if(endPage > maxPage) {
		endPage = maxPage;
	}
	
	let pgData = "";
	pgData += '<li class="page-item ' + (currPage == 1 ? 'disabled' : '') +'"><a class="page-link" href="#" onclick="getTsunamiShelter('+(currPage-1)+')">Previous</a></li>';
	for(let i = startPage; i <= endPage; i++) {
    	pgData += '<li class="page-item ' + (currPage == i ? 'active' : '') + '"><a class="page-link" href="#" onclick="getTsunamiShelter(' + (i) + ')">'+ i +'</a></li>'; 
    }
    pgData += '<li class="page-item ' + (currPage == maxPage ? 'disabled' : '') + '"><a class="page-link" href="#" onclick="getTsunamiShelter(' + (currPage+1) + ')">Next</a></li>';
    
    
	$('#page-area').html(pgData);
}