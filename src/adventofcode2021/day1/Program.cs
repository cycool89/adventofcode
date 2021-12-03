// See https://aka.ms/new-console-template for more information

using System;
using day1;

int sol1demo = new MeasurementCounter("./input_1_demo.dat").Count();
int sol1 = new MeasurementCounter("./input_1.dat").Count();

Console.WriteLine("[1 DEMO] " + sol1demo);
Console.WriteLine("[1 SOL ] " + sol1);


