

var lineChartData = {
			labels : ["01/2016","02/2016","03/2016","04/2016","05/2016","06/2016","07/2016","08/2016","09/2016","10/2016","11/2016","12/2016"],
			datasets : [
				
				{
					label: "Segunda serie de datos",
					fillColor : "rgba(151,187,205,0.2)",
					strokeColor : "#e9e225",
					pointColor : "#faab12",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(151,187,205,1)",
					data : [1000000,30000,20000,40000,850000,550000,150000,200000,900000,560000,300000,450000]
				}
			]

		}
                
                
                var ctx = document.getElementById("grafico").getContext("2d");
                window.myPie = new Chart(ctx).Line(lineChartData, {responsive:true});
