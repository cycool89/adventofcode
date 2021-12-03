// See https://aka.ms/new-console-template for more information

using System;
using day1;

var sol1demo = new MeasurementCounter("./input_1_demo.dat").Count();
var sol1 = new MeasurementCounter("./input_1.dat").Count();

var sol2demo = new WindowMeasurementCounter("./input_1_demo.dat").Count();
var sol2 = new WindowMeasurementCounter("./input_1.dat").Count();

Console.WriteLine("[1 DEMO] " + sol1demo);
Console.WriteLine("[1 SOL ] " + sol1);
Console.WriteLine("[2 DEMO] " + sol2demo);
Console.WriteLine("[2 SOL ] " + sol2);


