# Daily coding problem #31
# solution from geeksforgeeks

def editDistance(str1, str2):
	# create table to store results of subproblems
	m = len(str1)
	n = len(str2)
	table = [[0 for x in range(n+1)] for x in range(m+1)]
	
	# fill table in bottom up matter
	for i in range(m+1):
		for j in range(n+1):
			
			# if str1 is empty, we need to insert all characters from str2
			# in order to change str1 into str2
			if i == 0:
				table[i][j] = j
				
			# if str2 is empty, we need to remove all characters from str1
			# in order to change str1 into str2
			elif j == 0:
				table[i][j] = i
				
			# if the last characters of str1 and str2 are the same
			# ignore last character and add no additional cost
			# example: 'abbc' to 'acc' last characters are the same
			# thus cost is what it takes to change 'abb' to 'ac' only
			# fill the table with the diagonal value (i-1)(j-1) since we
			# ignore last character
			elif str1[i-1] == str2[j-1]:
				table[i][j] = table[i-1][j-1]
				
			# if the last characters are different, use min of insert/remove/replace
			# example: 'abb', 'ac'
			# 1) table[i][j-i] 'abb' , 'a' : the cost of converting 'abb'
			# to 'a', plus an additional step to insert 'c' into 'a'
			# to maken'ac'
			# 2) table[i-1][j] 'ab', 'ac' : the cost to convert 'ab' to 'ac' plus
			# an additional step to delete 'b' from 'abb'
			# 3) table[i-1][j-1] 'ab', 'a' : the cost to convert 'ab' to 'a' plus
			# an additional step to replace 'b' (last char of 'abb') to 'a' (last
			# char of 'ac')
			else:
				table[i][j] = 1 + min(table[i][j-1], #insert 
									  table[i-1][j], #remove
									  table[i-1][j-1]) #replace
				
	return table[m][n]
		
		
def main():
	str1 = 'sunday'
	str2 = 'saturday'
	
	print(editDistance(str1, str2))
	
if __name__ == '__main__':
	main()
				
				
				
				
				
				
		
