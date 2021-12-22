using System.Linq;

namespace day4;

public class BingoSubSystem
{
    private readonly string[] _data;
    private int[] _drawNumbers = null!;
    private readonly List<BingoBoard> _boards = new();
    private BingoBoard? _firstWinningBoard;
    private BingoBoard? _lastWinningBoard;

    public BingoSubSystem(string inputFile)
    {
        _data = File.ReadAllLines(inputFile);
        ProcessInput();
        MarkNumbers();
    }

    public BingoBoard? FirstWinningBoard => _firstWinningBoard;
    public BingoBoard? LastWinningBoard => _lastWinningBoard;

    private void ProcessInput()
    {
        var strings = _data[0].Split(",");
        _drawNumbers = Array.ConvertAll(strings, int.Parse);

        var fromIndex = 2;
        while (fromIndex < _data.Length)
        {
            var board = FillABoard(fromIndex);
            _boards.Add(board);
            fromIndex += 6;
        }
    }

    private BingoBoard FillABoard(int fromIndex)
    {
        BingoBoard board = new(5);
        for (var i = 0; i < 5; i++)
        {
            board.AddRow(_data[fromIndex + i]);
        }

        return board;
    }

    private void MarkNumbers()
    {
        var drawNumberIndex = 0;
        do
        {
            var actualDrawNumber = _drawNumbers[drawNumberIndex];
            foreach (var bingoBoard in _boards.ToList())
            {
                bingoBoard.Mark(actualDrawNumber);
                if (bingoBoard.IsWinning)
                {
                    if (_firstWinningBoard == null)
                    {
                        _firstWinningBoard = bingoBoard;
                        _lastWinningBoard = bingoBoard;
                    }
                    else
                    {
                        _lastWinningBoard = bingoBoard;
                    }

                    _boards.Remove(bingoBoard);
                }
            }
            drawNumberIndex++;
        } while (drawNumberIndex < _drawNumbers.Length);

    }
}