// See https://aka.ms/new-console-template for more information

using day4;

BingoSubSystem demo1 = new("./input_1_demo.dat");
BingoSubSystem sol1 = new("./input_1.dat");

var demo1Score = demo1.WinningBoard?.Score;
var sol1Score = sol1.WinningBoard?.Score;

Console.WriteLine($"[DEMO 1] {demo1Score}");
Console.WriteLine($"[SOL  1] {sol1Score}");
