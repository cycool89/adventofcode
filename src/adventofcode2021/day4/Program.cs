// See https://aka.ms/new-console-template for more information

using day4;

BingoSubSystem demo1 = new("./input_1_demo.dat");
BingoSubSystem sol1 = new("./input_1.dat");

Console.WriteLine($"[DEMO 1] {demo1.FirstWinningBoard?.Score}");
Console.WriteLine($"[SOL  1] {sol1.FirstWinningBoard?.Score}");
Console.WriteLine($"[DEMO 2] {demo1.LastWinningBoard?.Score}");
Console.WriteLine($"[SOL  2] {sol1.LastWinningBoard?.Score}");
