using System;
using System.IO;

namespace day2
{
    public class Submarine
    {
        public int Depth { get; private set; }
        public int Horizontal { get; private set; }
        private readonly string[] _data;

        public Submarine(string inputFile, int depth, int horizontal)
        {
            _data = File.ReadAllLines(inputFile);
            Depth = depth;
            Horizontal = horizontal;
        }

        public void Execute()
        {
            foreach (var line in _data)
            {
                var task = line.Split(" ");
                Enum.TryParse(task[0], true, out Directions direction);
                Int32.TryParse(task[1], out var amount);
                Move(direction, amount);
            }
        }

        private void Move(Directions direction, int amount)
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
    }
}