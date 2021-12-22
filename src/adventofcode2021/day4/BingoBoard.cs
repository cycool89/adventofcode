using System.Text.RegularExpressions;

namespace day4;

public class BingoBoard
{
    public bool IsWinning
    {
        get
        {
            var isWinning = false;
            var markedIndex = 0;
            do
            {
                if (_markedGrid[markedIndex] == 5)
                {
                    isWinning = true;
                }

                markedIndex++;
            } while (!isWinning && markedIndex < _markedGrid.Length);
            
            return isWinning;
        }
    }

    public int Score => _unmarkedGridSum * _lastDrawNumber;

    private readonly int[] _grid;
    // [...rowCount, ...colCount]
    private readonly int[] _markedGrid;
    private int _length = 0;
    private int _unmarkedGridSum = 0;
    private readonly int _boardSize;
    private int _lastDrawNumber = -1;
    private HashSet<int> _drawNumbers = new ();

    public BingoBoard(int boardSize)
    {
        _boardSize = boardSize;
        _grid = new int[boardSize * boardSize];
        _markedGrid = new int[2 * boardSize];
    }

    public void AddRow(string line)
    {
        var numbers = Array.ConvertAll(
            Regex.Split(line.Trim(), "\\s+"),
            int.Parse
        );
        foreach (var number in numbers)
        {
            _grid[_length++] = number;
            _unmarkedGridSum += number;
        }
    }

    public void Mark(int drawNumber)
    {
        if (_drawNumbers.Contains(drawNumber)) return;

        _drawNumbers.Add(drawNumber);
        _lastDrawNumber = drawNumber;
        var index = 0;
        var foundIndex = -1;
        do
        {
            if (_grid[index] == _lastDrawNumber)
            {
                foundIndex = index;
                var row = foundIndex / _boardSize;
                var col = foundIndex % _boardSize;
                _markedGrid[row]++;
                _markedGrid[_boardSize + col]++;
                _unmarkedGridSum -= _lastDrawNumber;
            }

            index++;
        } while (index < _grid.Length && foundIndex < 0);
    }
}