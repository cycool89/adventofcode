// See https://aka.ms/new-console-template for more information

using System;
using day2;

Submarine submarine1Demo = new Submarine("./input1_demo.dat", 0, 0);
Submarine submarine1 = new Submarine("./input1.dat", 0, 0);

submarine1Demo.Execute(1);
var result1Demo = submarine1Demo.Depth * submarine1Demo.Horizontal;
submarine1.Execute(1);
var result1 = submarine1.Depth * submarine1.Horizontal;

Console.WriteLine("[1 DEMO] " + result1Demo);
Console.WriteLine("[1     ] " + result1);

Submarine submarine2Demo = new Submarine("./input1_demo.dat", 0, 0, 0);
Submarine submarine2 = new Submarine("./input1.dat", 0, 0, 0);

submarine2Demo.Execute(2);
var result2Demo = submarine2Demo.Depth * submarine2Demo.Horizontal;
submarine2.Execute(2);
var result2 = submarine2.Depth * submarine2.Horizontal;

Console.WriteLine("[2 DEMO] " + result2Demo);
Console.WriteLine("[2     ] " + result2);
