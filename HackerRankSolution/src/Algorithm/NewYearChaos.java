package Algorithm;

public class NewYearChaos {

	public static int NumOfBribes(int[] EndPosition) throws Exception{
		int bribes=0;
		int pos = EndPosition.length -1;
		while (pos >0){
			int currentVal = EndPosition[pos];
			int expectedValue = pos+1;
			if (currentVal!= expectedValue){
				int delta = 100;
				if (EndPosition[pos -1] == expectedValue){
					delta = 1;
				}else if ((pos -2 >= 0)&& EndPosition[pos -2] == expectedValue){
					delta =2;
				}
				
				if (delta > 2){
					throw new Exception("Too chaotic");
				}
				bribes += delta;
				
				int starting = pos - delta;
				while (delta > 0){					
					int temp = EndPosition[starting+1];
					EndPosition[starting+1] =  EndPosition[starting];
					EndPosition[starting] = temp;
					delta--;
					starting++;
				}			
				
			}
			pos--;			
		}
		printListInteger(EndPosition);
		return bribes;
	}
	public static void printListInteger (int[] val){
		for(int p : val){
			System.out.print(p +" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int[] val1 = {2,1,4,5,3,8,7,10,6,12,11,9,15,13,16,18,14,19,21,17,23,22,20,26,24,27,25,29,28,31,30,34,32,36,35,38,33,40,39,37,43,42,41,46,44,48,47,50,45,51,52,49,55,54,53,58,57,59,56,62,60,64,63,61,67,68,66,65,69,72,70,74,73,71,75,78,79,76,81,80,77,84,83,86,82,88,87,85,91,89,92,94,93,90,97,96,95,99,101,98,100,103,102,106,105,107,104,110,109,108,113,112,115,114,117,111,119,116,121,120,123,122,125,126,118,124,129,130,127,128,133,132,131,136,134,135,137,140,139,141,138,144,143,145,142,148,147,146,151,150,149,153,152,156,154,158,159,157,155,162,160,164,163,161,167,166,169,165,171,168,173,172,170,176,175,178,177,174,179,180,183,184,182,181,187,186,189,185,191,192,190,188,194,193,197,195,196,198,201,199,203,202,200,206,205,204,208,210,207,209,212,211,215,213,216,214,219,218,220,217,223,222,221,224,225,228,226,230,231,229,227,234,233,232,237,236,235,240,239,241,238,244,243,242,247,246,245,250,251,249,248,254,253,252,257,256,255,260,259,258,263,262,261,264,267,266,269,270,268,265,273,274,271,276,275,272,277,280,279,278,282,284,281,286,285,283,287,290,291,288,289,293,292,296,294,297,299,300,295,298,303,302,301,305,307,304,309,308,306,312,310,314,313,311,317,315,319,320,316,322,323,321,318,325,324,328,327,326,331,332,330,334,329,333,335,336,339,337,338,342,341,344,340,343,347,345,349,348,346,352,351,353,350,356,354,355,357,358,361,359,362,364,363,360,365,367,366,368,370,369,373,371,375,372,374,378,377,380,379,382,376,384,385,381,383,388,387,386,390,389,393,392,391,396,395,398,394,397,401,399,403,402,405,404,400,408,406,410,411,407,413,409,415,414,412,417,419,416,418,420,421,424,423,422,425,427,429,430,426,432,431,428,435,436,434,433,438,439,437,441,440,444,445,443,447,442,446,450,448,452,451,449,453,456,454,457,455,460,459,458,463,462,461,466,465,468,464,470,469,472,471,467,475,474,473,478,479,477,480,482,476,481,485,486,483,488,484,487,491,490,489,494,493,492,497,496,498,495,501,502,499,500,504,503,506,505,507,510,511,509,508,513,512,516,517,515,518,514,521,519,523,520,522,526,525,528,524,530,531,529,527,534,533,536,532,537,535,540,539,538,542,544,541,545,543,547,546,550,548,552,551,553,549,556,554,558,559,555,561,557,563,562,560,566,564,568,565,569,570,572,567,573,571,575,576,574,577,580,581,578,579,584,585,586,582,587,583,589,588,592,591,594,590,593,597,595,599,596,598,602,601,600,605,603,604,608,607,606,611,612,609,614,615,610,616,613,619,618,617,622,620,624,625,621,627,623,626,630,629,628,633,631,635,636,634,638,632,639,637,640,642,644,643,641,647,645,649,648,646,652,653,650,651,656,655,654,658,657,661,660,659,664,663,662,665,668,669,667,671,666,673,670,675,674,677,678,676,672,681,679,683,680,685,684,682,687,686,690,691,689,693,688,692,695,694,698,697,696,700,702,701,699,704,706,703,707,705,710,709,711,708,714,712,716,715,713,719,717,720,718,722,724,723,721,727,726,725,729,731,728,730,734,733,732,736,735,739,738,741,737,740,744,745,743,747,742,749,748,750,746,753,751,755,752,757,754,759,756,758,761,762,760,765,763,764,766,768,769,770,767,773,771,772,776,775,778,777,774,781,780,782,779,785,783,787,784,789,786,791,790,792,788,795,796,794,793,799,798,797,802,801,804,800,806,803,808,809,807,805,811,813,812,815,810,817,814,816,818,821,819,823,822,825,824,820,828,826,830,829,827,832,834,831,836,837,835,833,838,841,839,840,844,842,846,845,843,847,850,848,849,853,851,855,856,854,852,859,858,860,857,862,861,864,865,863,868,867,866,871,869,873,870,872,876,877,874,879,880,881,882,875,883,885,878,884,887,886,890,888,892,889,894,893,896,897,891,895,900,898,902,901,904,899,903,906,908,905,907,911,910,913,912,909,914,915,916,919,917,920,918,922,921,923,926,925,924,927,928,930,929,933,932,935,931,936,934,939,938,937,942,941,940,945,944,943,948,947,946,951,952,950,949,955,954,956,953,957,960,959,961,958,962,963,966,964,967,965,969,968,972,970,973,971,975,977,978,974,976,981,979,980,984,982,986,983,988,989,985,991,987,993,992,990,996,994,995};
		System.out.println(NumOfBribes(val1));
		int[] val2 = {2,1,5,4,3};
		System.out.println(NumOfBribes(val2));
		int[] val3 = {2,1,3,5,4};
		System.out.println(NumOfBribes(val3));
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
