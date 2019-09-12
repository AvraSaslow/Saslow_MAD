//variables
var message : String = "Hello World" //variable name, type, message
let classMax : Int = 30 //constant called classMax that is an int = 30
var age : Int //not assigned a value yet
age = 20 //now that variable has an assigned value

var name = "Avra" //type inferences to infer type without explicitly stating it

//prints
print("Hi there")
print(age)
print("My name is \(name) and I am \(age) years old")

//data types
let a = 42
let b = 0.123
//c = a + b doesn't work because you can't add an int and a double
let c = Double(a) + b //a is still an int though

//tuples
//tuple is a way to group together multiple values in an informal way - mixed type, as many values as you'd like
let violet = ("#EE82EE", 238, 130, 238)
print(violet.0)
let (hex, red, green, blue) = violet
print(green)

//swift doesn't increment or decrement, you have to use += or -=
//!= is not equal, and &&

var young = "you can't drink"
var notyoung = "you can drink"

if age < 21 {
    print(young)
} else {
    print(notyoung)
}

//turnary operator
age < 21 ? young : notyoung //? is if, : is else

switch age {
case 0...5: //can omit first number
    print("You're young")
case 6...21: //if instead of third dot there was a < sign (half open range operator), 21 is excldued from cases and it goes to default (can do with < or >)
    print("Yehhhaww")
case 22...55: //can omit last number
    print("old")
default:
    print("I don't know what you're doing")
}

// no need for break statements, but you do need a default

for count in 0...age {
    print(count)
}

while age < 40 {
    print("young")
}
