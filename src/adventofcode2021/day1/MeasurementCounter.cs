using System;
using System.IO;

namespace day1
{
    public class MeasurementCounter
    {
        private readonly string[] _lines;

        public MeasurementCounter(string fileName)
        {
            _lines = File.ReadAllLines(fileName);
        }

        public int Count()
        {
            int countIncreasedMeasurements = 0;
            for (var i = 1; i < _lines.Length; i++)
            {
                var prevMeasurement = Convert.ToInt32(_lines[i-1]);
                var actMeasurement = Convert.ToInt32(_lines[i]);
                if (actMeasurement > prevMeasurement)
                {
                    countIncreasedMeasurements++;
                }
            }

            return countIncreasedMeasurements;
        }
    }
}