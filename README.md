# avaj-launcher
The introduction into java. My first OOP project.

The plan:

1)  Read the file and the number of iterations on the first line. 
	If there is a problem with it, throw an exception
2)  Read the rest of the file line by line validating each line.
	Every valid line is created as a respective object in observers arraylist and registered.
	Throw an exception in case something is wrong and put "" into the result file.
3)  For each iteration weatherTower.changeWeather() is called.
	changeWeather() -> conditionsChanged() -> iterate through the arraylist of observers ->
	updateConditions() -> getWeather() -> getCurrentWeather()
	log changes into the result file
	unregister an observer if its height is 0
