// See https://aka.ms/new-console-template for more information

using System;
using day3;
using lib;

DiagnosticSystem diagnosticSystem1demo = new("./input_1_demo.dat");
diagnosticSystem1demo.Analyze();
var gamma = Utils.BinToDec(diagnosticSystem1demo.Gamma);
var epsilon = Utils.BinToDec(diagnosticSystem1demo.Epsilon);

Console.WriteLine("[1 DEMO] " + (gamma * epsilon));

DiagnosticSystem diagnosticSystem1 = new("./input_1.dat");
diagnosticSystem1.Analyze();
gamma = Utils.BinToDec(diagnosticSystem1.Gamma);
epsilon = Utils.BinToDec(diagnosticSystem1.Epsilon);

Console.WriteLine("[1     ] " + (gamma * epsilon));
