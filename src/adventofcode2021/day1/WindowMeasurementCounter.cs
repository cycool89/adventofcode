using System;
using System.IO;

namespace day1
{
    public class WindowMeasurementCounter
    {
        private readonly string[] _lines;

        public WindowMeasurementCounter(string fileName)
        {
            _lines = File.ReadAllLines(fileName);
        }

        public int Count()
        {
            int countIncreasedMeasurements = 0;
            for (var i = 3; i < _lines.Length; i++)
            {
                var prevMeasurement = Convert.ToInt32(_lines[i - 1]) + Convert.ToInt32(_lines[i - 2]) +
                                      Convert.ToInt32(_lines[i - 3]);
                var actMeasurement = Convert.ToInt32(_lines[i]) + Convert.ToInt32(_lines[i - 1]) +
                                     Convert.ToInt32(_lines[i - 2]);
                if (actMeasurement > prevMeasurement)
                {
                    countIncreasedMeasurements++;
                }
            }

            return countIncreasedMeasurements;
        }
    }
}