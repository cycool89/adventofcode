using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace day3
{
    public class DiagnosticSystem
    {
        public string Gamma { get; private set; }
        public string Epsilon { get; private set; }
        private readonly string[] _data;

        public DiagnosticSystem(string inputFile)
        {
            _data = File.ReadAllLines(inputFile);
            Gamma = "";
            Epsilon = "";
        }

        public void Analyze()
        {
            var diagnosis = Diagnosis();

            SetGammaEpsilon(diagnosis);
        }

        private List<int> Diagnosis()
        {
            List<int> diagnosis = Enumerable.Repeat(0, _data[0].Length).ToList();
            foreach (var line in _data)
            {
                for (var j = 0; j < line.Length; j++)
                {
                    diagnosis[j] += line[j].ToString() == "1" ? 1 : -1;
                }
            }

            return diagnosis;
        }

        private void SetGammaEpsilon(List<int> diagnosis)
        {
            foreach (var diagnosisBit in diagnosis)
            {
                Gamma += diagnosisBit > 0 ? "1" : "0";
                Epsilon += diagnosisBit > 0 ? "0" : "1";
            }
        }
    }
}