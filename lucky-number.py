#Coded by KBJay
import time, sys
from random import randint

d_week = time.strftime("%w")   # Day of week
dif = 7 - int(d_week)   # Diffrence between 7 and day of week
print ("Today's date: " + time.strftime("%d/%m/%Y") )
# Printing out today's date: day, month, year
print('')
numbers = []

if len(sys.argv) == 2 and ( str(sys.argv[1]) == '-f' or '--force'):
	d_week = 1

# If you're gonna start app by adding -f or --force, you'll be able to randomize no matter what day is it
# On Linux to start app this way is to type in terminal: "python lucky-number.py -f" or instead of "-f" "--force"
# The instruction above these comments is checking that is the -f or --force have been used

else:
	d_week = time.strftime("%w")

#If you haven't use the "force" then day of week is just a actuall day of week

if int(d_week) > 1:
	print('The numbers are drawn on Mondays. Days to draw: ' + str(dif))

# If the day of week is greater than 1 (Monday), then the app says that the draw can't be done today
# And says how many days you'll have to wait for the next draw

elif int(d_week) == 0:
	print("The numbers are drawn on Mondays. You'll be able to draw tommorow")

# In the other case if day of week is 0 (Sunday), app says that you'll be able to draw next day

else:
	print('Lucky numbers for this week are:')
	
	def draw():
		while len(numbers) <= 5:
# A loop that keep randomizing numbers until 5 diffrent numbers will be not same
			los = randint(1,30)
# By deafult the draw range is set from 1 to 30, you can change it above
			los = str(los)			
			if los in numbers:
				continue
			else:
				numbers.append(los)
			
	draw()		
	print("Monday: " + numbers[0])
	print("Tuesday: " + numbers[1])
	print("Wednesday: " + numbers[2])
	print("Thursday: " + numbers[3])
	print("Friday: " + numbers[4])
