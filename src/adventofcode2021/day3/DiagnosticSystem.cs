using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using lib;

namespace day3
{
    public class DiagnosticSystem
    {
        public long PowerConsumption
        {
            get
            {
                var gamma = Utils.BinToDec(_gamma);
                var epsilon = Utils.BinToDec(_epsilon);
                return gamma * epsilon;
            }
        }

        public long LifeSupportRating
        {
            get
            {
                var oxygenGeneratorRating = Utils.BinToDec(_oxygenGeneratorRating);
                var co2ScrubberRating = Utils.BinToDec(_co2ScrubberRating);
                return oxygenGeneratorRating * co2ScrubberRating;
            }
        }

        private readonly string[] _data;
        private string _gamma = "";
        private string _epsilon = "";
        private string _oxygenGeneratorRating = "";
        private string _co2ScrubberRating = "";

        public DiagnosticSystem(string inputFile)
        {
            _data = File.ReadAllLines(inputFile);
            Analyze();
        }

        private void Analyze()
        {
            CalculatePowerConsumptionBits();
            CalculateLifeSupportRatingBits();
        }

        private void CalculatePowerConsumptionBits()
        {
            var diagnosis = Diagnosis();
            foreach (var diagnosisBit in diagnosis)
            {
                _gamma += diagnosisBit >= 0 ? "1" : "0";
                _epsilon += diagnosisBit >= 0 ? "0" : "1";
            }
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

        private void CalculateLifeSupportRatingBits()
        {
            _oxygenGeneratorRating = SearchRating(
                _data,
                0,
                (rawBitSummary) => rawBitSummary >= 0 ? '1' : '0'
            );
            _co2ScrubberRating = SearchRating(
                _data,
                0,
                (rawBitSummary) => rawBitSummary >= 0 ? '0' : '1'
            );
        }

        private static string SearchRating(string[] source, int bitIndex, Func<int, char> filterBit)
        {
            var rawBitSummary = BitSummary(source, bitIndex);
            var mostCommonBitByBitIndexIndex = filterBit(rawBitSummary);
            string[] rating = source.Where(line => line[bitIndex] == mostCommonBitByBitIndexIndex).ToArray();

            return rating.Length > 1 && bitIndex < source[0].Length
                ? SearchRating(rating, bitIndex + 1, filterBit)
                : rating[0];
        }

        private static int BitSummary(IEnumerable<string> input, int index)
        {
            return input.Sum(line => line[index] == '1' ? 1 : -1);
        }
    }
}