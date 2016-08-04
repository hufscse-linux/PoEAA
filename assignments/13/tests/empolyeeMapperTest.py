import unittest
import sys
import os
sys.path.insert(0, os.path.abspath('..'))
from mapper.empolyeeMapper import EmpolyeeMapper
from domain.empolyee import Empolyee
from domain.team import Team
from domain.project import Project
from domain.position import Position

class TeamMapperTest(unittest.TestCase):
    def setUp(self):
        self.empolyeeMapper = EmpolyeeMapper()

    def testFind(self):
        rs = self.empolyeeMapper.find(1)
        self.assertIsInstance(rs,  Empolyee)
        self.assertEqual(rs.en, 1)
        self.assertIsInstance(rs.project,  Project)
        self.assertIsInstance(rs.team,  Team)
        self.assertIsInstance(rs.position,  Position)

if __name__ == "__main__":
    unittest.main()
