// See https://aka.ms/new-console-template for more information

using System;
using day2;

Submarine submarine1Demo = new Submarine("./input1_demo.dat", 0, 0);
Submarine submarine1 = new Submarine("./input1.dat", 0, 0);

submarine1Demo.Execute();
var result1Demo = submarine1Demo.Depth * submarine1Demo.Horizontal;
submarine1.Execute();
var result1 = submarine1.Depth * submarine1.Horizontal;

Console.WriteLine("[1 DEMO] " + result1Demo);
Console.WriteLine("[1     ] " + result1);
