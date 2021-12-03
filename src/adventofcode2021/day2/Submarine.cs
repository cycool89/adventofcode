using System;
using System.IO;

namespace day2
{
    public class Submarine
    {
        public int Depth { get; private set; }
        public int Horizontal { get; private set; }
        public int Aim { get; private set; }
        private readonly string[] _data;

        public Submarine(string inputFile, int depth, int horizontal, int aim = 0)
        {
            _data = File.ReadAllLines(inputFile);
            Depth = depth;
            Horizontal = horizontal;
            Aim = aim;
        }

        public void Execute(int whichPartOfDay)
        {
            foreach (var line in _data)
            {
                var task = line.Split(" ");
                Enum.TryParse(task[0], true, out Directions direction);
                Int32.TryParse(task[1], out var amount);
                if (whichPartOfDay == 1)
                {
                    Move1(direction, amount);
                }
                else
                {
                    Move2(direction, amount);
                }
            }
        }

        private void Move1(Directions direction, int amount)
        {
            switch (direction)
            {
                case Directions.Forward:
                    Horizontal += amount;
                    break;
                case Directions.Down:
                    Depth += amount;
                    break;
                case Directions.Up:
                    Depth -= amount;
                    break;
                default:
                    throw new ArgumentOutOfRangeException(nameof(direction), direction, null);
            }
        }

        private void Move2(Directions direction, int amount)
        {
            switch (direction)
            {
                case Directions.Forward:
                    Horizontal += amount;
                    Depth += Aim * amount;
                    break;
                case Directions.Down:
                    Aim += amount;
                    break;
                case Directions.Up:
                    Aim -= amount;
                    break;
                default:
                    throw new ArgumentOutOfRangeException(nameof(direction), direction, null);
            }
        }
    }
}