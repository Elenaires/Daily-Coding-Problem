/* daily coding problem #109 */

/* Given an unsigned 8-bit integer, swap its even and odd bits.
* The 1st and 2nd bit should be swapped, the 3rd and 4th bit
* should be swapped, and so on.
*
* For example, 10101010 should be 01010101. 11100010 should be 11010001.
*/

public class SwapEvenOddBits
{
	public static void main(String[] args)
	{
		int number = 226; // 11100010 --> 11010001
		System.out.println(Integer.toBinaryString(number));
		System.out.println(Integer.toBinaryString(swapBits(number)));
	}
	
	public static int swapBits(int number)
	{
		/* 0xAAAAAAAA is a 32 bit number with all even bits set as 1
		* and all odd bits as 0 for example 10101010
		* & operator gives 1 if both operands have 1 else 0
		* 1110010 & 10101010 gives 10100010
		* purpose: extract all even bits (1) of a number
		*/
		int even = number & 0xAAAAAAAA;

		/* 0x55555555 is a 32 but number with all odd bits set as 1
		* and all even bits as 0
		* 11100010 & 01010101 gives 01000000
		* purpose: extract all odd bits (1) of a number
		*/
		int odd = number & 0x55555555;


		// swapping-like action takes place here
		// shift even position bit 1 bit to the right
		// shift odd position bit 1 bit to the left
		// merge both using OR bitwise operator

		/* shift right by 1 - add 1 zero on the left and shift the rest right
		* last bit on right will be gone
		* 10100010 --> 01010001
		*/
		even = even >> 1;

		/* shift left by 1 - add 1 zero on the right and shift the rest left
		* last bit on the left will be gone
		* 01000000 --> 10000000
		*/
		odd = odd << 1;

		/* combine odd and even bits 
		* 01010001 | 10000000 --> 11010001
		*/
		return (even | odd);
	}
}
