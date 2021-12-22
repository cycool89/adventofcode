// See https://aka.ms/new-console-template for more information

using System;
using day3;

DiagnosticSystem diagnosticSystemDemo = new("./input_1_demo.dat");
DiagnosticSystem diagnosticSystem = new("./input_1.dat");

Console.WriteLine("[1 DEMO] " + diagnosticSystemDemo.PowerConsumption);
Console.WriteLine("[1     ] " + diagnosticSystem.PowerConsumption);
Console.WriteLine("[2 DEMO] " + diagnosticSystemDemo.LifeSupportRating);
Console.WriteLine("[2     ] " + diagnosticSystem.LifeSupportRating);
