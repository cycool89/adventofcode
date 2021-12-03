using System;
using System.IO;

namespace day1
{
    public class MeasurementCounter
    {
        private string[] lines;

        public MeasurementCounter(string fileName)
        {
            lines = File.ReadAllLines(fileName);
        }

        public int Count()
        {
            int countIncreasedMeasurements = 0;
            for (var i = 1; i < lines.Length; i++)
            {
                var prevMeasurement = Convert.ToInt32(lines[i-1]);
                var actMeasurement = Convert.ToInt32(lines[i]);
                if (actMeasurement > prevMeasurement)
                {
                    countIncreasedMeasurements++;
                }
            }

            return countIncreasedMeasurements;
        }
    }
}